package com.naulitraders.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.naulitraders.dao.DBConnection;
import com.naulitraders.dao.LoginDao;

@WebServlet("/login")
public class ValidateUser extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
		RequestDispatcher dispatcher1 = request.getRequestDispatcher("/Login.jsp");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// call DAO for validation logic
		LoginDao dao = new LoginDao();
		boolean isValidUser = dao.validateUser(username, password);

		// check if user is valid and set up an error message
		if (isValidUser) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			dispatcher.forward(request, response);
		} else {

			String successMessage = "Invalid Credentials,please login again!";
			request.setAttribute("messageType", "alert-success");
			request.setAttribute("message", successMessage);
			dispatcher1.forward(request, response);
			
		}
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.jsp");
		dispatcher.forward(request, response);
	}

}
