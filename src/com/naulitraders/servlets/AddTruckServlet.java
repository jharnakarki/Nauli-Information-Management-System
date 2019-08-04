package com.naulitraders.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naulitraders.dao.TruckDao;
import com.naulitraders.model.TruckInfo;

@WebServlet("/addVehicle")
public class AddTruckServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/trucks/AddVehicle.jsp");

		String number = request.getParameter("num");
		String brand = request.getParameter("brand");
		int model = Integer.parseInt(request.getParameter("model"));
		int capacity = Integer.parseInt(request.getParameter("capacity"));
		int tyres = Integer.parseInt(request.getParameter("tyres"));
		int year = Integer.parseInt(request.getParameter("year"));
		String status = request.getParameter("isStatus");

		// fill it up the model
		TruckInfo truckInfo = new TruckInfo(number, brand, model, capacity, tyres, year,status);

		// validate truck info
		try {
			validateTruckInfo(truckInfo);
		} catch (IllegalArgumentException e) {
			// write the message back to the page in client browser\
			String errorMessage = e.getMessage();

			request.setAttribute("messageType", "alert-danger");
			request.setAttribute("message", errorMessage);
			dispatcher.forward(request, response);
			return;
		}

		// call the DAO layer and save the truck info
		TruckDao applicationDao = new TruckDao();
		applicationDao.insertTruckInfo(truckInfo);

		// set the success message and send it through dispatcher
		String successMessage = "Truck Info successfully added";
		request.setAttribute("messageType", "alert-success");
		request.setAttribute("message", successMessage);
		dispatcher.forward(request, response);

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/trucks/AddVehicle.jsp");
		dispatcher.forward(request, response);
	}

	private void validateTruckInfo(TruckInfo truckInfo) {

		if (truckInfo.getYear() > LocalDate.now().getYear()) {
			throw new IllegalArgumentException("Year of a truck cannot be future year");
		}

	}
}
