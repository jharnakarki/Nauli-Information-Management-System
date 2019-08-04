package com.naulitraders.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naulitraders.dao.TruckDao;
import com.naulitraders.model.TruckInfo;

/*
 * This class will display the list of all the trucks in the system
 */
@WebServlet("/ShowTrucks")
public class TruckInfoServlet extends HttpServlet {
	
	private TruckDao truckDao = new TruckDao();
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/trucks/ShowTrucks.jsp");
		
		// get the saved trucks from the database
		List<TruckInfo> listOfTrucks = truckDao.getTrucksList();
		
		
		// add the truck info for jsp
		request.setAttribute("listOfTrucks", listOfTrucks);
		dispatcher.forward(request, response);
		
	}

}
