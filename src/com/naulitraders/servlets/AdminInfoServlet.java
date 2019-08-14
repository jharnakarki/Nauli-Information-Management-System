package com.naulitraders.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naulitraders.dao.AdminDao;
import com.naulitraders.model.AdminInfo;

@WebServlet("/ShowAdmin")
public class AdminInfoServlet extends HttpServlet {
	
	private AdminDao adminDao = new AdminDao();
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/ShowAdmin.jsp");
		
		// get the saved trucks from the database
		List<AdminInfo> listOfAdmins = adminDao.getAdminsList();
		
		// add admins info for jsp
		request.setAttribute("listOfAdmins", listOfAdmins);
		dispatcher.forward(request, response);
		
	}

}
