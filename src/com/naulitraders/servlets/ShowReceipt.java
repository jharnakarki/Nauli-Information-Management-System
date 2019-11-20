package com.naulitraders.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naulitraders.utility.EnvironmentUtil;

@WebServlet("/ShowReceipt")
public class ShowReceipt extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		String receiptId = request.getParameter("receiptId");

		if (receiptId == null) {
			throw new IllegalArgumentException("Receipt Id is invalid");
		}

		response.setContentType("image/jpeg");
		response.setHeader("Content-disposition", "inline; filename=receipt.jpeg");

		String filePath = EnvironmentUtil.getWorkDirectoryPath() + File.separator + "receipt" + File.separator
				+ receiptId;
		
		if(new File(filePath + ".jpeg").exists()) {
			filePath += ".jpeg"; 
		} else {
			filePath += ".jpg";
		}

		try (InputStream in = new FileInputStream(new File(filePath)); OutputStream out = response.getOutputStream()) {

			byte[] bytes = new byte[1024];

			int read;
			while ((read = in.read(bytes)) != 0) {
				out.write(bytes, 0, read);
			}
		} catch (FileNotFoundException fne) {
			
			String errorMessage = "Receipt not found for receipt Id " + receiptId;
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/404.jsp");
			request.setAttribute("404Message", errorMessage);
			
			dispatcher.forward(request, response);
			
		}
	}

}
