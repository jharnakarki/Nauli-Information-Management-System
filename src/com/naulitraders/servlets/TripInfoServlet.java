package com.naulitraders.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import com.naulitraders.dao.TripDao;
import com.naulitraders.model.TripInfo;

/*
 * This class will display the list of all the trucks in the system
 */
@WebServlet("/ShowTrips")
public class TripInfoServlet extends HttpServlet {
	
	private TripDao tripDao = new TripDao();
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ShowTrips.jsp");
		
		// get the saved trucks from the database
		List<TripInfo> listOfTrips = tripDao.getTripsList();
		
		
		// add the trip info for jsp
		request.setAttribute("listOfTrips", listOfTrips);
		dispatcher.forward(request, response);
		
	}

}