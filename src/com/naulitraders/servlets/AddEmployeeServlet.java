package com.naulitraders.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naulitraders.dao.EmployeeDao;
import com.naulitraders.model.EmployeeInfo;
import com.naulitraders.utility.ValidationUtil;

@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet {

	private EmployeeDao employeeDao = new EmployeeDao();

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/employee/AddEmployee.jsp");

		String name = request.getParameter("name");
		String position = request.getParameter("position");
		Long phoneNumber = Long.parseLong(request.getParameter("phoneNumber"));
		double salary = Double.parseDouble(request.getParameter("salary"));

		// fill it up the model
		EmployeeInfo employeeInfo = new EmployeeInfo(name, position, phoneNumber, salary);
		
		// validate employee info
		try {
			validateEmployeeInfo(employeeInfo);
		} catch (IllegalArgumentException e) {
			// write the message back to the page in client browser\
			String errorMessage = e.getMessage();

			request.setAttribute("messageType", "alert-danger");
			request.setAttribute("message", errorMessage);
			dispatcher.forward(request, response);
			return;
		}

		// call the DAO layer and save the employee info
		employeeDao.insertEmployeeInfo(employeeInfo);

		// set the success message and send it through dispatcher
		String successMessage = "Employee Info successfully added";
		request.setAttribute("messageType", "alert-success");
		request.setAttribute("message", successMessage);
		dispatcher.forward(request, response);

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/employee/AddEmployee.jsp");
		dispatcher.forward(request, response);
	}

	private void validateEmployeeInfo(EmployeeInfo employeeInfo) {
		ValidationUtil.validatePhoneNumber(employeeInfo.getPhoneNumber());

		// two employee cannot have same phone number
		if (employeeDao.isEmployeeAlreadyExist(employeeInfo.getPhoneNumber(),employeeInfo.getEmpId())) {
			throw new IllegalArgumentException("Employee with that phone number already exist in our system");
		}
		
		// position cannot be not available
				if (employeeInfo.getPosition().equals("NA")) {
					throw new IllegalArgumentException("Select the position");
				}
	}
}
