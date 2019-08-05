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
import com.naulitraders.model.ExpenseInfo;
import com.naulitraders.model.ProfitLossAccount;
import com.naulitraders.model.TripInfo;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

	private TripDao tripDao = new TripDao();

	private ExpenseDao expensesDao = new ExpenseDao();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("vehicleNumber") != null) {
			String vehicleNumber = request.getParameter("vehicleNumber");

			LocalDate startDate = LocalDate.parse(request.getParameter("startDate"));

			LocalDate endDate = LocalDate.parse(request.getParameter("endDate"));
			ProfitLossAccount pl = getProfitAndLoss(vehicleNumber, startDate, endDate);
			
			request.setAttribute("profitLoss", pl);
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

}