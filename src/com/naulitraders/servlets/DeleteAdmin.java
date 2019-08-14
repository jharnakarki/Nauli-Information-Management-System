package com.naulitraders.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.naulitraders.dao.AdminDao;

@WebServlet("/deleteAdmin")
public class DeleteAdmin extends HttpServlet {
	
	private AdminDao adminDao = new AdminDao();
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		
		// validate
		boolean isAdminExist = adminDao.isAdminAlreadyExist(username);
		
		if(!isAdminExist) {
			String message = "Admin do not exist for delete";
			request.setAttribute("404Message", message);
			request.getRequestDispatcher("/404.jsp").forward(request, response);
			return;
		}
		
		// You cannot delete the currently logged admin
		HttpSession session = request.getSession();
		String currentlyLoggedInUser = (String) session.getAttribute("username");
		
		if(username.equals(currentlyLoggedInUser)) {
			String message = "Cannot delete the currently logged user";
			request.setAttribute("404Message", message);
			request.getRequestDispatcher("/404.jsp").forward(request, response);
			return;
		}
		
		// delete the admin
		adminDao.deleteAdmin(username);
		
		// go back to show admin page
		response.sendRedirect("ShowAdmin");
	}

}
