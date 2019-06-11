package com.naulitraders.servlets;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.TimeZone;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidateUser extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html");

		String url = "jdbc:mysql://localhost:3306/Project?serverTimezone=" + TimeZone.getDefault().getID();
		String uname = "root";
		String pwd = "";
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			PrintWriter pw = response.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver");
			// create connection to database
			Connection con = DriverManager.getConnection(url, uname, pwd);
			String sql = "select * from admins";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String name = rs.getString("username");
				String pass = rs.getString("password");
				if (username.equals(name) && password.equals(pass)) {
					HttpSession session = request.getSession();
					session.setMaxInactiveInterval(60);

					response.sendRedirect("home.html");
				}

				else {
					pw.println("Wrong username or password");
				}

			}

			con.close();

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
