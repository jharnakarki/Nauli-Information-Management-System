package com.naulitraders.servlets;

import java.io.*;
import java.sql.*;
import java.util.TimeZone;

import javax.servlet.http.*;
public class CreateAdmin extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html");
		String url="jdbc:mysql://localhost:3306/Project?serverTimezone=" + TimeZone.getDefault().getID();
		String uname="root";
		String pwd="";
			
			String username=request.getParameter("names");
			String password=request.getParameter("pass");
		
			try {
				//load the database driver
				Class.forName("com.mysql.jdbc.Driver");
				//create connection to database
				Connection con= DriverManager.getConnection(url,uname,pwd);
				String sql="insert into Admins(username,password) values(?,?)";
				PreparedStatement pst=con.prepareStatement(sql);
				pst.setString(2,username);
				pst.setString(2,password);
				
			
				pst.execute();
				con.close();
				System.out.println("Admin created");
		}
		catch(Exception ex) {
			System.out.println(ex);
			
		}
		
	}
}




