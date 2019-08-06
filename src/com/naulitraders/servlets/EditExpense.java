package com.naulitraders.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naulitraders.dao.ExpenseDao;
import com.naulitraders.model.ExpenseInfo;

@WebServlet("/editExpense")

public class EditExpense extends HttpServlet {

	private ExpenseDao expenseDao = new ExpenseDao();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("expenseId") == null) {

			// show 404.jsp, edit trip cannot work without tripId

			showPage("/404.jsp", request, response);

			return;

		}

		int expenseId = Integer.parseInt(request.getParameter("expenseId"));

		ExpenseInfo expenseInfo = expenseDao.getExpense(expenseId);

		if (expenseInfo == null) {

			// when expense cannot be found

			showPage("/404.jsp", request, response);

			return;

		}

		request.setAttribute("expenseInfo", expenseInfo);

		showPage("/expenses/EditExpense.jsp", request, response);

	}

	@Override

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String number = request.getParameter("vehNum");
		LocalDate expenseDate = LocalDate.parse(request.getParameter("expenseDate"));
		double amount = Double.parseDouble(request.getParameter("amount"));
		String remarks = request.getParameter("remarks");
		int expenseId = Integer.parseInt(request.getParameter("expenseId"));

		// fill it up the model, with setExpenseId for update

		ExpenseInfo expenseInfo = new ExpenseInfo(number, expenseDate, amount, remarks);

		expenseInfo.setExpenseId(expenseId);

		// validate expense info

		try {

			validateExpenseInfo(expenseInfo);

		} catch (IllegalArgumentException e) {

			// write the message back to the page in client browser

			String errorMessage = e.getMessage();
			request.setAttribute("messageType", "alert-danger");
			request.setAttribute("message", errorMessage);
			request.setAttribute("expenseInfo", expenseInfo);
			showPage("/expenses/EditExpense.jsp", request, response);
			return;

		}

		// update the expense

		expenseDao.updateExpense(expenseInfo);

		// get the expense after update

		ExpenseInfo updatedExpenseInfo = expenseDao.getExpense(expenseId);
		request.setAttribute("messageType", "alert-success");
		request.setAttribute("message", "Expenses has been updated successfully !");
		request.setAttribute("expenseInfo", updatedExpenseInfo);
		showPage("/expenses/EditExpense.jsp", request, response);
	}

	private void showPage(String pageName, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher(pageName);
		dispatcher.forward(request, response);
	}

	private void validateExpenseInfo(ExpenseInfo expenseInfo) {
		
				// validate start and end date of a trip are not of future date
				if (expenseInfo.getExpenseDate().isAfter(LocalDate.now())) {
					throw new IllegalArgumentException("Date of a expense date cannot be future date");
				}	
	}

}
