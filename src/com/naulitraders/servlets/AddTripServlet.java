package com.naulitraders.servlets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naulitraders.dao.TripDao;
import com.naulitraders.model.TripInfo;
import com.naulitraders.utility.ValidationUtil;
@WebServlet("/addTrip")
public class AddTripServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		String url = "jdbc:mysql://localhost:3306/Project?serverTimezone=" + TimeZone.getDefault().getID();
		String uname = "root";
		String pwd = "";
		String number = request.getParameter("vehNum");
		// converting util data into sql date
		java.util.Date start = new SimpleDateFormat("yyyy/MM/dd").parse(request.getParameter("dtStart"));
		java.util.Date end = new SimpleDateFormat("yyyy/MM/dd").parse(request.getParameter("dtEnd"));
		java.sql.Date sqlDate = new java.sql.Date(start.getTime());
		java.sql.Date sqlEndDate = new java.sql.Date(end.getTime());

		int sMil = Integer.parseInt(request.getParameter("maStart"));
		int eMil = Integer.parseInt(request.getParameter("maEnd"));
		String orig = request.getParameter("org");
		String mul = request.getParameter("mulDes");
		int reve = Integer.parseInt(request.getParameter("rev"));
		String nam = request.getParameter("dName");
		String rem = request.getParameter("remarks");

		// fill it up the model
		TripInfo tripInfo = new TripInfo(number, sqlDate, sqlEndDate, sMil, eMil, orig, mul, reve, nam, rem);
		
		// validate truck info
		try
		{
			validateTripInfo(tripInfo);
		}
		catch(IllegalArgumentException e)
		{
			// write the message back to the page in client browser\
			String errorMessage = e.getMessage();
			String page = getHTMLString(request.getServletContext().getRealPath("NewTrip.html"), "alert-danger",
					errorMessage);
			response.getWriter().write(page);
			return;
		}
		
		// call the DAO layer and save the truck info
		TripDao applicationDao = new TripDao();applicationDao.insertTripInfo(tripInfo);

		String successMessage = "Trip Info successfully added";

		// write the message back to the page in client browser\
		String page = getHTMLString(request.getServletContext().getRealPath("NewTrip.html"), "alert-success",
				successMessage);response.getWriter().write(page);
		}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String page = getHTMLString(req.getServletContext().getRealPath("NewTrip.html"), "", "");
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
	private void validateTripInfo(TripInfo truckInfo) {

		if (tripInfo.getStartDate() > LocalDate.now().getDate()) {
			throw new IllegalArgumentException("Date of a trip cannot be future year");
		}
	}
}




	

	
	

	

	

	
	