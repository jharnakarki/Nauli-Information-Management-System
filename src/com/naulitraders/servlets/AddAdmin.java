package com.naulitraders.servlets;
import java.io.*;
import java.sql.*;
import java.util.TimeZone;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/addAdmin")
public class AddAdmin extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html");
		String url = "jdbc:mysql://localhost:3306/Project?serverTimezone=" + TimeZone.getDefault().getID();
		String uname = "root";
		String pwd = "";

		String username = request.getParameter("name");
		String password = request.getParameter("pass");

		try {
			// load the database driver
			Class.forName("com.mysql.jdbc.Driver");
			// create connection to database
			Connection con = DriverManager.getConnection(url, uname, pwd);
			PrintWriter pw = response.getWriter();
			String sql = "insert into Admins(username,password) values(?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			pst.execute();
			pw.println("<html><body>");
			pw.println("<h2>Your record is successfully uploaded</h2>");
			pw.println("</body></html>");
			pw.close();
			con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
