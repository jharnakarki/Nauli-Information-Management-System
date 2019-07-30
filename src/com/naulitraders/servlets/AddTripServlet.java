package com.naulitraders.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naulitraders.dao.TripDao;
import com.naulitraders.dao.TruckDao;
import com.naulitraders.model.TripInfo;
import com.naulitraders.model.TruckInfo;

@WebServlet("/addTrip")
public class AddTripServlet extends HttpServlet {

	private TruckDao truckDao = new TruckDao();

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/AddTrip.jsp");
		// get the list of trucks so you can add it to the drop down
		// it is needed here too because after POST, when the page reload, we require truck list again
		List<TruckInfo> listOfTrucks = truckDao.getTrucksList();
		request.setAttribute("listOfTrucks", listOfTrucks);

		// get the request
		String number = request.getParameter("vehNum");
		LocalDate departureDate = LocalDate.parse(request.getParameter("dtStart"));
		LocalDate arrivalDate = LocalDate.parse(request.getParameter("dtEnd"));
		int sMil = Integer.parseInt(request.getParameter("maStart"));
		int eMil = Integer.parseInt(request.getParameter("maEnd"));
		String orig = request.getParameter("org");
		String mul = request.getParameter("mulDes");
		int reve = Integer.parseInt(request.getParameter("rev"));
		String nam = request.getParameter("dName");
		String rem = request.getParameter("remarks");

		// fill it up the model
		TripInfo tripInfo = new TripInfo(number, departureDate, arrivalDate, sMil, eMil, orig, mul, reve, nam, rem);

		// validate truck info
		try {
			validateTripInfo(tripInfo);
		} catch (IllegalArgumentException e) {
			// write the message back to the page in client browser
			String errorMessage = e.getMessage();

			request.setAttribute("messageType", "alert-danger");
			request.setAttribute("message", errorMessage);
			dispatcher.forward(request, response);
			return;
		}

		// call the DAO layer and save the truck info
		TripDao tripDao = new TripDao();
		tripDao.insertTripInfo(tripInfo);

		// set the success message and send it through dispatcher
		String successMessage = "Trip Info successfully added";
		request.setAttribute("messageType", "alert-success");
		request.setAttribute("message", successMessage);
		dispatcher.forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// get the list of trucks so you can add it to the drop down
		List<TruckInfo> listOfTrucks = truckDao.getTrucksList();
		request.setAttribute("listOfTrucks", listOfTrucks);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/AddTrip.jsp");
		dispatcher.forward(request, response);
	}

	private void validateTripInfo(TripInfo tripInfo) {
		// truck number cannot be not available
		if (tripInfo.getTruckNumber().equals("NA")) {
			throw new IllegalArgumentException("Truck Number cannot be not available");
		}

		// validate start and end date of a trip are not of future date
		if (tripInfo.getStartDate().isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("Date of a start date cannot be future date");
		}

		if (tripInfo.getEndDate().isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("End date of a trip cannot be future date");
		}

		// validate endMileage should be always greater than start mileage
		if (tripInfo.getStartMileage() > tripInfo.getEndMileage()) {
			throw new IllegalArgumentException("ending mileage should be more than start mileage");
		}

	}
}
