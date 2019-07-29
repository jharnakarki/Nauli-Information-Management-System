package com.naulitraders.servlets;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.naulitraders.dao.ExpenseDao;
import com.naulitraders.model.ExpenseInfo;
import com.naulitraders.utility.ValidationUtil;

@WebServlet("/addExpenses")
public class AddExpServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher Dispatcher=request.getRequestDispatcher("/AddExpenses.jsp");
		response.setContentType("text/html");

		//get the request
		String number = request.getParameter("num");
		LocalDate expenseDate = LocalDate.parse(request.getParameter("dat"));
		Double amount = Double.parseDouble(request.getParameter("amt"));
		String remark = request.getParameter("remarks");
		InputStream inputStream = null; // input stream of the upload file
		 File imgfile = new File("bill");
//		Part filePart = request.getPart("bill");
//		if (filePart != null) {
//			// prints out some information for debugging
//			System.out.println(filePart.getName());
//			System.out.println(filePart.getSize());
//			System.out.println(filePart.getContentType());
//
//			// obtains input stream of the upload file
//			inputStream = filePart.getInputStream();
//		}
	      FileInputStream fin = new FileInputStream(imgfile);


		// fill it up the model
		ExpenseInfo expenseInfo = new ExpenseInfo(number, amount,remark,expenseDate, fin);

		// validate truck info
		try {
			validateExpenseInfo(expenseInfo);
		} catch (IllegalArgumentException e) {
			// write the message back to the page in client browser\
			String errorMessage = e.getMessage();
			String page = getHTMLString(request.getServletContext().getRealPath("expense.jsp"), "alert-danger",
					errorMessage);
			response.getWriter().write(page);
			return;
		}

		// call the DAO layer and save the truck info
		ExpenseDao applicationDao = new ExpenseDao();
		applicationDao.insertExpenseInfo(expenseInfo);

		String successMessage = "Expense Info successfully added";

		// write the message back to the page in client browser\
		String page = getHTMLString(request.getServletContext().getRealPath("expense.jsp"), "alert-success",
				successMessage);
		response.getWriter().write(page);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String page = getHTMLString(req.getServletContext().getRealPath("Expense.jsp"), "", "");
		resp.getWriter().write(page);
	}

	public String getHTMLString(String filePath, String messageType, String message) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String line = "";
		StringBuffer buffer = new StringBuffer();
		while ((line = reader.readLine()) != null) {
			buffer.append(line);
		}

		reader.close();
		String page = buffer.toString();

		page = MessageFormat.format(page, messageType, message);

		return page;
	}

	private void validateExpenseInfo(ExpenseInfo expenseInfo) {

		if (expenseInfo.getAmount() > 0) {
			throw new IllegalArgumentException("Amount should be positive");
		}
	}
}
