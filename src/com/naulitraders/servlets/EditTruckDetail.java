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
		// get the truckNumber from the URL query parameter
		String queryString = request.getQueryString(); // return something like : truckNumber=Dhh134
		String queryStringArray[] = queryString.split("="); // split with = and add it to array, [0] = truckNumber and
															// [1] = Dhh134

		String truckNumber = queryStringArray[1];
		String status = request.getParameter("isStatus");

		// fill it up the model, with setTruckNumber for update
		TruckInfo truckInfo = new TruckInfo();
		truckInfo.setTruckNumber(truckNumber);
		truckInfo.setStatus(status);

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
		TruckInfo updatedTruckInfo = truckDao.getTruckDetail(truckNumber);
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
		// Date shouldnot be of future
				if (truckInfo.getYear() > LocalDate.now().getYear()) {
					throw new IllegalArgumentException("Year of a truck cannot be future year");
				}
				// validation for even truck tyres
				int tyres = truckInfo.getTyres();
				if (tyres % 2 != 0) {

					throw new IllegalArgumentException("Number of tyres should be even");
				}
				
	}

}
