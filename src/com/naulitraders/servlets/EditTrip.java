package com.naulitraders.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naulitraders.dao.TripDao;
import com.naulitraders.model.TripInfo;

@WebServlet("/editTrip")
public class EditTrip extends HttpServlet {

	private TripDao tripDao = new TripDao();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("tripId") == null) {
			// show 404.jsp, edit trip cannot work without tripId
			showPage("/404.jsp", request, response);
			return;
		}

		int tripId = Integer.parseInt(request.getParameter("tripId"));

		TripInfo tripInfo = tripDao.getTrip(tripId);

		if (tripInfo == null) {
			// when trip cannot be found
			showPage("/404.jsp", request, response);
			return;
		}

		request.setAttribute("tripInfo", tripInfo);
		showPage("/trips/EditTrip.jsp", request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String number = request.getParameter("vehNum");
		LocalDate departureDate = LocalDate.parse(request.getParameter("dtStart"));
		LocalDate arrivalDate = LocalDate.parse(request.getParameter("dtEnd"));
		int sMil = Integer.parseInt(request.getParameter("maStart"));
		int eMil = Integer.parseInt(request.getParameter("maEnd"));
		String orig = request.getParameter("org");
		String mul = request.getParameter("mulDes");
		double reve = Double.parseDouble(request.getParameter("rev"));
		String nam = request.getParameter("dName");
		String rem = request.getParameter("remarks");
		int tripId = Integer.parseInt(request.getParameter("tripId"));

		// fill it up the model, with setTripId for update
		TripInfo tripInfo = new TripInfo(number, departureDate, arrivalDate, sMil, eMil, orig, mul, reve, nam, rem);
		tripInfo.setTripId(tripId);

		// validate truck info
		try {
			validateTripInfo(tripInfo);
		} catch (IllegalArgumentException e) {
			// write the message back to the page in client browser
			String errorMessage = e.getMessage();

			request.setAttribute("messageType", "alert-danger");
			request.setAttribute("message", errorMessage);
			request.setAttribute("tripInfo", tripInfo);
			showPage("/trips/EditTrip.jsp", request, response);
			return;
		}

		// update the trip
		tripDao.updateTrip(tripInfo);

		// get the trip after update
		TripInfo updatedTripInfo = tripDao.getTrip(tripId);

		request.setAttribute("messageType", "alert-success");
		request.setAttribute("message", "Trip has been updated successfully !");
		request.setAttribute("tripInfo", updatedTripInfo);
		showPage("/trips/EditTrip.jsp", request, response);

	}

	private void showPage(String pageName, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(pageName);
		dispatcher.forward(request, response);
	}

	private void validateTripInfo(TripInfo tripInfo) {

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
