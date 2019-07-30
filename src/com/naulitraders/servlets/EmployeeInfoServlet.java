package com.naulitraders.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naulitraders.dao.EmployeeDao;
import com.naulitraders.model.EmployeeInfo;

/*
 * This class will display the list of all the employees in the system
 */
@WebServlet("/ShowEmployees")
public class EmployeeInfoServlet extends HttpServlet {
	
	private EmployeeDao employeeDao = new EmployeeDao();
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ShowEmployees.jsp");
		
		// get the saved Employees from the database
		List<EmployeeInfo> listOfEmployees = employeeDao.getEmployeesList();
		
		
		// add the Employees info for jsp
		request.setAttribute("listOfEmployees", listOfEmployees);
		dispatcher.forward(request, response);
		
	}

}
