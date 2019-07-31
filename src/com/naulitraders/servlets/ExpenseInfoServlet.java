package com.naulitraders.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naulitraders.dao.ExpenseDao;
import com.naulitraders.model.ExpenseInfo;

/*
 * This class will display the list of all the expenses in the system
 */
@WebServlet("/ShowExpenses")
public class ExpenseInfoServlet extends HttpServlet {
	
	private ExpenseDao expenseDao = new ExpenseDao();
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/expenses/ShowExpense.jsp");
		
		// get the saved Expenses from the database
		List<ExpenseInfo> listOfExpenses = expenseDao.getExpenseList();
		
		
		// add the Expenses info for jsp
		request.setAttribute("listOfExpenses", listOfExpenses);
		dispatcher.forward(request, response);
		
	}

}
