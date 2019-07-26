package com.naulitraders.servlets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.time.LocalDate;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naulitraders.dao.EmployeeDao;
import com.naulitraders.model.EmployeeInfo;
import com.naulitraders.utility.ValidationUtil;

@WebServlet("/addEmployee")
public class AddEmpServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		String name=request.getParameter("name");
		int age=Integer.parseInt(request.getParameter("age"));
		String ads=request.getParameter("address");
		int contact=Integer.parseInt(request.getParameter("phone"));
		String position=request.getParameter("pos");
	    int salary=Integer.parseInt(request.getParameter("salary"));
	    //String cid=request.getParameter("prove");
	    
		// fill it up the model
	    EmployeeInfo employeeInfo = new EmployeeInfo(name, age, ads, contact, position, salary);
		// validate truck info
		try {
		validateEmployeeInfo(employeeInfo);
		} catch(IllegalArgumentException e) {
		// write the message back to the page in client browser\
		String errorMessage = e.getMessage();
		String page = getHTMLString(request.getServletContext().getRealPath("Employee.html"), "alert-danger", errorMessage);
		response.getWriter().write(page);
		return;
		}
		// call the DAO layer and save the truck info
		EmployeeDao applicationDao = new EmployeeDao();
		applicationDao.insertEmployeeInfo(employeeInfo);
		String successMessage = "Truck Info successfully added";
		// write the message back to the page in client browser\
		String page = getHTMLString(request.getServletContext().getRealPath("Employee.html"), "alert-success", successMessage);
		response.getWriter().write(page);
		}
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String page = getHTMLString(req.getServletContext().getRealPath("Employee.html"), "", "");
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

		private void validateEmployeeInfo(EmployeeInfo EmployeeInfo) {

		if (EmployeeInfo.getContact() > 10||EmployeeInfo.getContact()<10) {
		throw new IllegalArgumentException("Contact number should be of 10digit");
		}
		}
		}

		
			
		
		   
			