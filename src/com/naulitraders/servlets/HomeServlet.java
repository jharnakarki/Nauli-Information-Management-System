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

import com.naulitraders.dao.ExpenseDao;
import com.naulitraders.dao.TripDao;
import com.naulitraders.dao.TruckDao;
import com.naulitraders.model.EmployeeInfo;
import com.naulitraders.model.ExpenseInfo;
import com.naulitraders.model.ProfitLossAccount;
import com.naulitraders.model.TripInfo;
import com.naulitraders.model.TruckInfo;
import com.naulitraders.utility.ValidationUtil;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

	private TripDao tripDao = new TripDao();
	private TruckDao truckDao = new TruckDao();
	private ExpenseDao expensesDao = new ExpenseDao();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get the list of trucks so you can add it to the drop down
		// it is needed here too because after POST, when the page reload, we require
		// truck list again
		List<TruckInfo> listOfTrucks = truckDao.getTrucksList();
		request.setAttribute("listOfTrucks", listOfTrucks);

		if (request.getParameter("vehicleNumber") != null) {
			String vehicleNumber = request.getParameter("vehicleNumber");
			if(!vehicleNumber.equalsIgnoreCase("NA")){
				LocalDate startDate = LocalDate.parse(request.getParameter("startDate"));
		
				LocalDate endDate = LocalDate.parse(request.getParameter("endDate"));
				ProfitLossAccount pl = getProfitAndLoss(vehicleNumber, startDate, endDate);
	
				request.setAttribute("profitLoss", pl);	
			} else {
				String successMessage = "Please select truck number";
				request.setAttribute("messageType", "alert-danger");
				request.setAttribute("message", successMessage);
			}
			
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
		dispatcher.forward(request, response);

		
		

	}

		
	public ProfitLossAccount getProfitAndLoss(String vehicleNumber, LocalDate startDate, LocalDate endDate) {

		List<TripInfo> trips = tripDao.getTrips(vehicleNumber, startDate, endDate);
		double totalRevenue = trips.stream().map(trip -> trip.getRevenue()).reduce(0d, Double::sum);

		List<ExpenseInfo> expenses = expensesDao.getExpenses(vehicleNumber, startDate, endDate);
		double totalExpenses = expenses.stream().map(expense -> expense.getAmount()).reduce(0d, Double::sum);

		ProfitLossAccount pl = new ProfitLossAccount();
		pl.setTrips(trips);
		pl.setExpenses(expenses);
		pl.setTotalRevenue(totalRevenue);
		pl.setTotalExpenses(totalExpenses);
		pl.setProfitLoss((totalRevenue - totalExpenses));

		return pl;

	}
//	private void validateTripInfo(TripInfo tripInfo) {
//		// truck number cannot be not available
//		if (tripInfo.getTruckNumber().equals("NA")) {
//			throw new IllegalArgumentException("Truck Number cannot be not available");
//		}
//		// validate start and end date of a trip are not of future date
//				if (tripInfo.getStartDate().isAfter(LocalDate.now())) {
//					throw new IllegalArgumentException("Date of a start date cannot be future date");
//				}
//
//				if (tripInfo.getEndDate().isAfter(LocalDate.now())) {
//					throw new IllegalArgumentException("End date of a trip cannot be future date");
//				}	
//	}
	
	
}