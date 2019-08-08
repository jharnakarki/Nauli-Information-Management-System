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

@WebServlet("/editEmployee")

public class EditEmpDetail extends HttpServlet {

	private EmployeeDao employeeDao = new EmployeeDao();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("empId") == null) {

			// show 404.jsp, edit trip cannot work without empId

			showPage("/404.jsp", request, response);

			return;

		}

		int empId = Integer.parseInt(request.getParameter("empId"));
		EmployeeInfo employeeInfo = employeeDao.getEmployee(empId);

		if (employeeInfo == null) {
			// when emp cannot be found
			showPage("/404.jsp", request, response);
			return;

		}

		request.setAttribute("employeeInfo", employeeInfo);
		showPage("/employee/EditEmployee.jsp", request, response);

	}

	@Override

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String name = request.getParameter("name");
		String position = request.getParameter("position");
		Long phoneNumber = Long.parseLong(request.getParameter("phoneNumber"));
		double salary = Double.parseDouble(request.getParameter("salary"));
		int empId = Integer.parseInt(request.getParameter("empId"));

		// fill it up the model, with setEmpId for update

		EmployeeInfo employeeInfo = new EmployeeInfo(name, position, phoneNumber, salary);
		employeeInfo.setEmpId(empId);

		// validate Employee info

		try {

			validateEmployeeInfo(employeeInfo);

		} catch (IllegalArgumentException e) {

			// write the message back to the page in client browser

			String errorMessage = e.getMessage();
			request.setAttribute("messageType", "alert-danger");
			request.setAttribute("message", errorMessage);
			request.setAttribute("employeeInfo", employeeInfo);
			showPage("/employee/EditEmployee.jsp", request, response);
			return;

		}

		// update the Employee
		employeeDao.updateEmployee(employeeInfo);

		// get the trip after update
		EmployeeInfo updatedEmployeeInfo = employeeDao.getEmployee(empId);
		request.setAttribute("messageType", "alert-success");
		request.setAttribute("message", "Employee has been updated successfully !");
		request.setAttribute("employeeInfo", updatedEmployeeInfo);
		showPage("/employee/EditEmployee.jsp", request, response);

	}

	private void showPage(String pageName, HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(pageName);
		dispatcher.forward(request, response);

	}

	private void validateEmployeeInfo(EmployeeInfo employeeInfo) {
		ValidationUtil.validatePhoneNumber(employeeInfo.getPhoneNumber());

		// two employee cannot have same phone number
		if (employeeDao.isEmployeeAlreadyExist(employeeInfo.getPhoneNumber())) {
			throw new IllegalArgumentException("Employee with that phone number already exist in our system");
		}
		
		// position cannot be not available
				if (employeeInfo.getPosition().equals("NA")) {
					throw new IllegalArgumentException("Select the position");
				}
	}

}
