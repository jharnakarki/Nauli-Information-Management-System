package com.naulitraders.servlets;
import java.text.SimpleDateFormat;
import java.io.*;
import java.sql.*;
import javax.servlet.http.*;

public class ReadTrips extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html");
		
			int number=Integer.parseInt(request.getParameter("vehNum"));
			
			int sMil=Integer.parseInt(request.getParameter("maStart"));
			int eMil=Integer.parseInt(request.getParameter("maEnd"));
			String orig=request.getParameter("org");
			String mul=request.getParameter("mulDes");
			int reve=Integer.parseInt(request.getParameter("rev"));
			String nam=request.getParameter("dName");
			String rem=request.getParameter("remarks");
			
			try {
				 java.util.Date start = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("Sdate")); 
				PrintWriter pw=response.getWriter();
				pw.println("<html><body>");
				pw.println("<h2>num"+number+"<h2>");
				pw.println("<h2>date"+start+"<h2>");
				pw.println("<h2>startMil"+sMil+"<h2>");
				pw.println("<h2>endMil"+eMil+"<h2>");
				pw.println("</body></html>");
				
		}
		catch(Exception ex) {
			System.out.println(ex);
			
		}
		
	}
}



