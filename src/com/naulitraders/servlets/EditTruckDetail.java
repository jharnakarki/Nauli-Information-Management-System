package com.naulitraders.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naulitraders.dao.TruckDao;
import com.naulitraders.model.TruckInfo;

@WebServlet("/editTruckDetail")

public class EditTruckDetail extends HttpServlet {

	private TruckDao truckDao = new TruckDao();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("truckNumber") == null) {

			// show 404.jsp, edit trip cannot work without empId

			showPage("/404.jsp", request, response);

			return;

		}

		String truckNumber = request.getParameter("truckNumber");
		TruckInfo truckInfo = truckDao.getTruckDetail(truckNumber);

		if (truckInfo == null) {
			// when emp cannot be found
			showPage("/404.jsp", request, response);
			return;

		}

		request.setAttribute("truckInfo", truckInfo);
		showPage("/trucks/EditTrucks.jsp", request, response);

	}

	@Override

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String vehNumber = request.getParameter("truckNumber");
		String brand = request.getParameter("brand");
		int model = Integer.parseInt(request.getParameter("model"));
		int capacity = Integer.parseInt(request.getParameter("capacity"));
		int tyres = Integer.parseInt(request.getParameter("tyres"));
		int year = Integer.parseInt(request.getParameter("year"));
		String status = request.getParameter("isStatus");
		

		// fill it up the model, with setTruckNumber for update

		TruckInfo truckInfo = new TruckInfo(vehNumber, brand, model, capacity, tyres, year, status);
		truckInfo.setTruckNumber(vehNumber);

		// validate Truck info

		try {

			validateTruckInfo(truckInfo);

		} catch (IllegalArgumentException e) {

			// write the message back to the page in client browser

			String errorMessage = e.getMessage();
			request.setAttribute("messageType", "alert-danger");
			request.setAttribute("message", errorMessage);
			request.setAttribute("truckInfo", truckInfo);
			showPage("/trucks/EditTrucks.jsp", request, response);
			return;

		}

		// update the truckInformation
		truckDao.updateTruck(truckInfo);

		// get the truckInformation after update
		TruckInfo updatedTruckInfo = truckDao.getTruckDetail(vehNumber);
		request.setAttribute("messageType", "alert-success");
		request.setAttribute("message", "Truck Details has been updated successfully !");
		request.setAttribute("truckInfo", updatedTruckInfo);
		showPage("/trucks/EditTrucks.jsp", request, response);

	}

	private void showPage(String pageName, HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(pageName);
		dispatcher.forward(request, response);

	}

	private void validateTruckInfo(TruckInfo truckInfo) {

	}

}
