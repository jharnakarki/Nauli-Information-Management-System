package com.naulitraders.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naulitraders.dao.AdminDao;
import com.naulitraders.model.AdminInfo;
import com.naulitraders.utility.ValidationUtil;

@WebServlet("/addAdmins")
public class AddAdmin extends HttpServlet {

	private AdminDao adminDao = new AdminDao();

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/AddAdmins.jsp");

		String name = request.getParameter("username");
		String password = request.getParameter("password");
		

		// fill it up the model
		AdminInfo adminInfo = new AdminInfo(name,password);

		// validate employee info
		try {
			validateAdminInfo(adminInfo);
		} catch (IllegalArgumentException e) {
			// write the message back to the page in client browser\
			String errorMessage = e.getMessage();

			request.setAttribute("messageType", "alert-danger");
			request.setAttribute("message", errorMessage);
			dispatcher.forward(request, response);
			return;
		}

		// call the DAO layer and save the employee info
		adminDao.insertAdminInfo(adminInfo);

		// set the success message and send it through dispatcher
		String successMessage = "Admin successfully added";
		request.setAttribute("messageType", "alert-success");
		request.setAttribute("message", successMessage);
		dispatcher.forward(request, response);

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/AddAdmins.jsp");
		dispatcher.forward(request, response);
	}

	private void validateAdminInfo(AdminInfo adminInfo) {
		
		// two employee cannot have same phone number
		if (adminDao.isAdminAlreadyExist(adminInfo.getUsername())) {
			throw new IllegalArgumentException("username with that name already exists");
		}
	}
}
