package com.naulitraders.servlets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.time.LocalDate;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naulitraders.dao.ApplicationDao;
import com.naulitraders.model.TruckInfo;
import com.naulitraders.utility.ValidationUtil;

public class AddTruckServlet extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setContentType("text/html");

		String number = request.getParameter("num");
		String brand = request.getParameter("brand");
		int model = Integer.parseInt(request.getParameter("model"));
		int capacity = Integer.parseInt(request.getParameter("capacity"));
		int tyres = Integer.parseInt(request.getParameter("tyres"));
		int year = Integer.parseInt(request.getParameter("year"));
		
		// fill it up the model
		TruckInfo truckInfo = new TruckInfo(number, brand, model, capacity, tyres, year);
		
		// validate truck info
		try {
			validateTruckInfo(truckInfo);
		} catch(IllegalArgumentException e) {
			// write the message back to the page in client browser\
			String errorMessage = e.getMessage();
			String page = getHTMLString(request.getServletContext().getRealPath("AddVehicle.html"), "alert-danger", errorMessage);
			response.getWriter().write(page);
			return;
		}
		
		
		// call the DAO layer and save the truck info
		ApplicationDao applicationDao = new ApplicationDao();
		applicationDao.insertTruckInfo(truckInfo);
		
		String successMessage = "Truck Info successfully added";
		
		// write the message back to the page in client browser\
		String page = getHTMLString(request.getServletContext().getRealPath("AddVehicle.html"), "alert-success", successMessage);
		response.getWriter().write(page);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String page = getHTMLString(req.getServletContext().getRealPath("AddVehicle.html"), "", "");
		resp.getWriter().write(page);
	}
	
	
	public String getHTMLString(String filePath, String messageType, String message) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String line="";
		StringBuffer buffer = new StringBuffer();
		while((line=reader.readLine())!=null){
			buffer.append(line);
		}
		
		reader.close();
		String page = buffer.toString();
		
		page = MessageFormat.format(page, messageType, message);
		
		return page;		
	}

	private void validateTruckInfo(TruckInfo truckInfo) {

		if (truckInfo.getYear() > LocalDate.now().getYear()) {
			throw new IllegalArgumentException("Year of a truck cannot be future year");
		}
	}
}
