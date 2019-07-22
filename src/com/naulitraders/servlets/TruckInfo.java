package com.naulitraders.servlets;

import java.io.*;
import java.sql.*;
import java.util.TimeZone;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;

public class TruckInfo extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("tsext/html");
		String url = "jdbc:mysql://localhost:3306/Project?serverTimezone=" + TimeZone.getDefault().getID();
		String uname = "root";
		String pwd = "";
		String number = request.getParameter("num");
		String brand = request.getParameter("brand");
		int model = Integer.parseInt(request.getParameter("model"));
		int capacity = Integer.parseInt(request.getParameter("capacity"));
		int tyres = Integer.parseInt(request.getParameter("tyres"));
		int year = Integer.parseInt(request.getParameter("year"));
		try {
			// load the database driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// create connection to database
			Connection con = DriverManager.getConnection(url, uname, pwd);
			PrintWriter pw=response.getWriter();
			String sql = "insert into tckInfo(vehNumber,brand,model,capacity,tyres,year) values(?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, number);
			pst.setString(2, brand);
			pst.setInt(3, model);
			pst.setInt(4, capacity);
			pst.setInt(5, tyres);
			pst.setInt(6, year);
			pst.execute();
			pw.println("<html><body>");
			pw.println("<h2>Your record is successfully uploaded</h2>");
			pw.println("</body></html>");
			pw.close();
			con.close();
			} 
		catch (Exception ex) {
			System.out.println(ex);

		}

	}
}
