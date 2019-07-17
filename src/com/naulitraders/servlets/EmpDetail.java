package com.naulitraders.servlets;
import java.io.*;
import java.sql.*;
import java.util.TimeZone;
import javax.servlet.http.*;
public class EmpDetail extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html");
		String url="jdbc:mysql://localhost:3306/Project?serverTimezone=" + TimeZone.getDefault().getID();
		String uname="root";
		String pwd="";
			
			String name=request.getParameter("name");
			int age=Integer.parseInt(request.getParameter("age"));
			String ads=request.getParameter("address");
			int contact=Integer.parseInt(request.getParameter("phone"));
			String position=request.getParameter("pos");
		    int salary=Integer.parseInt(request.getParameter("salary"));
		    //String cid=request.getParameter("prove");
			try {
				//load the database driver
				Class.forName("com.mysql.jdbc.Driver");
				//create connection to database
				Connection con= DriverManager.getConnection(url,uname,pwd);
				String sql="insert into Employee(name,age,address,phone,position,salary) values(?,?,?,?,?,?)";
				PreparedStatement pst=con.prepareStatement(sql);
				pst.setString(1, name);
				pst.setInt(2,age );
				pst.setString(3,ads );
				pst.setInt(4, contact);
				pst.setString(5,position);
				pst.setInt(6, salary);
				
				pst.execute();
				con.close();
				System.out.println("Record inserted");
		}
		catch(Exception ex) {
			System.out.println(ex);
			
		}
		
	}
}





