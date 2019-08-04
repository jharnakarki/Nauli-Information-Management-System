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
import com.naulitraders.dao.TruckDao;
import com.naulitraders.model.ExpenseInfo;
import com.naulitraders.model.TruckInfo;

@WebServlet("/addExpense")
public class AddExpenseServlet extends HttpServlet {
	private TruckDao truckDao = new TruckDao();

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/expenses/AddExpense.jsp");
		// get the list of trucks so you can add it to the drop down
		// it is needed here too because after POST, when the page reload, we require
		// truck list again
		List<TruckInfo> listOfActiveTrucks = truckDao.getActiveTrucksList();
		request.setAttribute("listOfActiveTrucks", listOfActiveTrucks);

		// get the request
		String number = request.getParameter("truckNumber");
		LocalDate expenseDate = LocalDate.parse(request.getParameter("expenseDate"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		String rem = request.getParameter("remarks");

		// fill it up the model
		ExpenseInfo expenseInfo = new ExpenseInfo(number, expenseDate, amount, rem);

		// validate expense info
		try {
			validateExpenseInfo(expenseInfo);
		} catch (IllegalArgumentException e) {
			// write the message back to the page in client browser
			String errorMessage = e.getMessage();

			request.setAttribute("messageType", "alert-danger");
			request.setAttribute("message", errorMessage);
			dispatcher.forward(request, response);
			return;
		}

		// call the DAO layer and save the expense info
		ExpenseDao expenseDao = new ExpenseDao();
		expenseDao.insertExpenseInfo(expenseInfo);

		// set the success message and send it through dispatcher
		String successMessage = "Expense Info successfully added";
		request.setAttribute("messageType", "alert-success");
		request.setAttribute("message", successMessage);
		dispatcher.forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// get the list of trucks so you can add it to the drop down
		List<TruckInfo> listActiveOfTrucks = truckDao.getActiveTrucksList();
		request.setAttribute("listOfActiveTrucks", listActiveOfTrucks);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/expenses/AddExpense.jsp");
		dispatcher.forward(request, response);
	}

	private void validateExpenseInfo(ExpenseInfo expenseInfo) {

		// truck number cannot be not available
		if (expenseInfo.getTruckNumber().equals("NA")) {
			throw new IllegalArgumentException("Truck Number cannot be not available");
		}
		// validate start and end date of a trip are not of future date
		if (expenseInfo.getExpenseDate().isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("Date of a expense date cannot be future date");
		}

	}
}
