package com.naulitraders.servlets;

import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import javax.servlet.http.*;

public class Expenses extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html");
		String url="jdbc:mysql://localhost:3306/Project?serverTimezone=" + TimeZone.getDefault().getID();
		String uname="root";
		String pwd="";
			String number=request.getParameter("num");
			Double amount=Double.parseDouble(request.getParameter("amt"));
			String bill=request.getParameter("bill");
			String remark=request.getParameter("remarks");
			
			
			try {
				 java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dat"));
		 
				 java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
				
				//load the database driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				//create connection to database
				Connection con= DriverManager.getConnection(url,uname,pwd);
				String sql="insert into expenses(vehNum,dates,amount,bill,remarks) values(?,?,?,?,?)";
				PreparedStatement pst=con.prepareStatement(sql);
				pst.setString(1, number);
				pst.setDate(2,sqlDate);
				pst.setDouble(3, amount);
				pst.setString(4, bill);
				pst.setString(5, remark);
				
			
				pst.execute();
				con.close();
				System.out.println("Record inserted");
		}
		catch(Exception ex) {
			System.out.println(ex);
			
		}
		
	}
}

