package com.naulitraders.servlets;
import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import javax.servlet.http.*;

public class Trip extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html");
		String url="jdbc:mysql://localhost:3306/Project?serverTimezone=" + TimeZone.getDefault().getID();
		String uname="root";
		String pwd="";
			String number=request.getParameter("vehNum");
			int sMil=Integer.parseInt(request.getParameter("maStart"));
			int eMil=Integer.parseInt(request.getParameter("maEnd"));
			String orig=request.getParameter("org");
			String mul=request.getParameter("mulDes");
			int reve=Integer.parseInt(request.getParameter("rev"));
			String nam=request.getParameter("dName");
			String rem=request.getParameter("remarks");
			
			try {
				 java.util.Date start = new SimpleDateFormat("yyyy/MM/dd").parse(request.getParameter("dtStart"));
				 java.util.Date end = new SimpleDateFormat("yyyy/MM/dd").parse(request.getParameter("dtEnd")); 
				 java.sql.Date sqlDate = new java.sql.Date(start.getTime());
				 java.sql.Date sqlEndDate = new java.sql.Date(end.getTime());
				//load the database driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				//create connection to database
				Connection con= DriverManager.getConnection(url,uname,pwd);
				String sql="insert into trip(vehNum,stDate,edDate,maStart,maEng,origin,mulDes,rev,dName,remarks) values(?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement pst=con.prepareStatement(sql);
				pst.setString(1, number);
				pst.setDate(2,sqlDate);
				pst.setDate(3,sqlEndDate);
				pst.setInt(4,sMil );
				pst.setInt(5, eMil);
				pst.setString(6, orig);
				pst.setString(7, mul);
				pst.setInt(8, reve);
				pst.setString(9,nam );
				pst.setString(10,rem);
			
				pst.execute();
				con.close();
				System.out.println("Record inserted");
		}
		catch(Exception ex) {
			System.out.println(ex);
			
		}
		
	}
}


