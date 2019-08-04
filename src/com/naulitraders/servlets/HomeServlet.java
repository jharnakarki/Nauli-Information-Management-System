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
			getProfitAndLoss(vehicleNumber, startDate, endDate);
		}

		List<TripInfo> listOfTrips = getRecentTrips();

		RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");

		request.setAttribute("listOfTrips", listOfTrips);
		dispatcher.forward(request, response);

	}

	public List<TripInfo> getRecentTrips() {

		return tripDao.getTrips(10);

	}

	public void getProfitAndLoss(String vehicleNumber, LocalDate startDate, LocalDate endDate) {

		double totalRevenue = tripDao.getTotalRevenue(vehicleNumber, startDate, endDate);

		double totalExpenses = expensesDao.getTotalExpenses(vehicleNumber, startDate, endDate);

		System.out.println(totalRevenue);

		System.out.println(totalExpenses);

	}

}