package com.naulitraders.servlets;

import java.io.*;
import java.sql.*;
import java.util.TimeZone;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.mysql.cj.util.StringUtils;

@WebServlet("/login")
public class ValidateUser extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.html");
		dispatcher.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html");

		String url = "jdbc:mysql://localhost:3306/Project?serverTimezone=" + TimeZone.getDefault().getID();
		String uname = "root";
		String pwd = "";
		String username = request.getParameter("username");
		String password = request.getParameter("password");
	
		PrintWriter pw = null;
		
		try {
			pw = response.getWriter();
			validateUser(username, password);
			Class.forName("com.mysql.cj.jdbc.Driver");
			// create connection to database
			Connection con = DriverManager.getConnection(url,uname, pwd);
			String sql = "select * from admins";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String name = rs.getString("username");
				String pass = rs.getString("password");
				if (username.equals(name) && password.equals(pass)) {
					HttpSession session = request.getSession();
					session.setMaxInactiveInterval(60);

					response.sendRedirect("home");
				}

				else {
					pw.println("<html><body>");
					pw.println("<h2>Your record is successfully uploaded</h2>");
					pw.println("</body></html>");
				}

			}

			con.close();

		} catch (IllegalArgumentException e) {
			if(pw != null) {
				pw.println(e.getMessage());
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
	private void validateUser(String username, String password) {
		if(username == null || username == "") {
			throw new IllegalArgumentException("Username cannot be empty");
		}
		
		if(password == null || password == "") {
			throw new IllegalArgumentException("Password cannot be empty");
		}
	}
			
}
