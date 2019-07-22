package com.naulitraders.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import javax.servlet.http.*;

public class Expenses extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html");
		String url="jdbc:mysql://localhost:3306/Project?serverTimezone=" + TimeZone.getDefault().getID();
		String uname="root";
		String pwd="";
			String number=request.getParameter("num");
			Double amount=Double.parseDouble(request.getParameter("amt"));
			
			String remark=request.getParameter("remarks");
			 InputStream inputStream = null; // input stream of the upload file
			 try {
				//converting utildate in sqldate format
				 java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dat"));
				 java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
				 // obtains the upload file part in this multipart request
			        Part filePart = request.getPart("bill");
			        if (filePart != null) {
			            // prints out some information for debugging
			            System.out.println(filePart.getName());
			            System.out.println(filePart.getSize());
			            System.out.println(filePart.getContentType());

			            // obtains input stream of the upload file
			            inputStream = filePart.getInputStream();
			        }
				
				
				//load the database driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				//create connection to database
				Connection con= DriverManager.getConnection(url,uname,pwd);
				PrintWriter pw=response.getWriter();
				String sql="insert into expenses(vehNum,dates,amount,bill,remarks) values(?,?,?,?,?)";
				PreparedStatement pst=con.prepareStatement(sql);
				pst.setString(1, number);
				pst.setDate(2,sqlDate);
				pst.setDouble(3, amount);
				 if (inputStream != null) {
		                // fetches input stream of the upload file for the blob column
		                pst.setBlob(3, inputStream);
		            }
				pst.setString(5, remark);
				pst.execute();
				pw.println("<html><body>");
				pw.println("<h2>Your record is successfully uploaded</h2>");
				pw.println("</body></html>");
				pw.close();
				con.close();
				
		}
		catch(Exception ex) {
			System.out.println(ex);
			
		}
		
	}
}
