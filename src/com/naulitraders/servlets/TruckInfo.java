package com.naulitraders.servlets;
import java.io.*;
import java.sql.*;
import javax.servlet.http.*;

public class TruckInfo extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html");
		String url="jdbc:mysql://localhost:3306/Project";
		String uname="root";
		String pwd="";
			int number=Integer.parseInt(request.getParameter("num"));
			String brand=request.getParameter("brand");
			int model=Integer.parseInt(request.getParameter("model"));
			int capacity=Integer.parseInt(request.getParameter("cap"));
			int tyres=Integer.parseInt(request.getParameter("tyres"));
		    int year=Integer.parseInt(request.getParameter("year"));
			try {
				//load the database driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				//create connection to database
				Connection con= DriverManager.getConnection(url,uname,pwd);
				String sql="insert into tckInfo(vehNumber,brand,model,capacity,tyres,year) values(?,?,?,?,?,?)";
				PreparedStatement pst=con.prepareStatement(sql);
				pst.setInt(1, number);
				pst.setString(2,brand );
				pst.setInt(3, model);
				pst.setInt(4, capacity);
				pst.setInt(5, tyres);
				pst.setInt(6, year);
			
				pst.execute();
				con.close();
				System.out.println("Record inserted");
		}
		catch(Exception ex) {
			System.out.println(ex);
			
		}
		
	}
}


