package com.naulitraders.servlets;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.naulitraders.dao.ExpenseDao;
import com.naulitraders.dao.TruckDao;
import com.naulitraders.model.ExpenseInfo;
import com.naulitraders.model.TruckInfo;
import com.naulitraders.utility.EnvironmentUtil;

@WebServlet("/addExpense")
@MultipartConfig
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
		String truckNumber = request.getParameter("truckNumber");
		LocalDate expenseDate = LocalDate.parse(request.getParameter("expenseDate"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		String rem = request.getParameter("remarks");

		// fill it up the model
		ExpenseInfo expenseInfo = new ExpenseInfo(truckNumber, expenseDate, amount, rem);

		
		Part filePart = request.getPart("receipt");
		String fileName = getFileName(filePart);

		// validate expense info and uploaded file name
		try {
			validateExpenseInfo(expenseInfo, fileName);
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
		int expenseId = expenseDao.insertExpenseInfo(expenseInfo);

		// write file after inserting expenses into database
		String outputFileName = String.valueOf(expenseId) + ".jpeg";
		writeFile(filePart, outputFileName);

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

	private void validateExpenseInfo(ExpenseInfo expenseInfo, String receiptFileName) {

		// truck number cannot be not available
		if (expenseInfo.getTruckNumber().equals("NA")) {
			throw new IllegalArgumentException("Truck Number cannot be not available");
		}
		// validate start and end date of a trip are not of future date
		if (expenseInfo.getExpenseDate().isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("Date of a expense date cannot be future date");
		}
		
		if (!receiptFileName.endsWith(".jpeg")) {
			throw new IllegalArgumentException("File must be in jpeg format");
		}

	}

	private String getFileName(Part part) {
		final String partHeader = part.getHeader("content-disposition");
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

	private void writeFile(Part filePart, String fileName) throws IOException {
		String destinationPath = EnvironmentUtil.getWorkDirectoryPath() + File.separator + "receipt";
		OutputStream out = null;
		InputStream filecontent = null;

		try {
			out = new FileOutputStream(new File(destinationPath + File.separator + fileName));
			filecontent = filePart.getInputStream();

			int read = 0;
			final byte[] bytes = new byte[1024];

			while ((read = filecontent.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
		} catch (FileNotFoundException fne) {
			throw new IllegalArgumentException("File not found : " + fne.getMessage());
		} finally {
			if (out != null) {
				out.close();
			}
			if (filecontent != null) {
				filecontent.close();
			}
		}
	}
}
