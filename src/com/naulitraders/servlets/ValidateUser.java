package com.naulitraders.servlets;

import java.io.*;
import java.sql.*;


import javax.servlet.http.*;
public class ValidateUser extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response)  {
response.setContentType("text/html");

String url="jdbc:mysql://localhost:3306/Project";
String uname="root";
String pwd="";
String username=request.getParameter("username");
String password=request.getParameter("password");
try {
	PrintWriter pw=response.getWriter();
	Class.forName("com.mysql.cj.jdbc.Driver");
	//create connection to database
	Connection con= DriverManager.getConnection(url,uname,pwd);
	String sql="select * from admins";
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(sql);
	while(rs.next()) {
		String name=rs.getString("username");
	    String pass=rs.getString("password");
	    if(username.equals(name) && password.equals(pass))
	      {
	        HttpSession session=request.getSession();
	        session.setMaxInactiveInterval(60);
	        
	        response.sendRedirect("home.html");
	      }
	   
	    else {
	    	pw.println("Wrong username or password");
			}
		
	}
	
	
     
	con.close();
	

	}
catch(Exception ex) {
		System.out.println(ex);
	}
}
}





