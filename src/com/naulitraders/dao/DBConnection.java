package com.naulitraders.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

import com.naulitraders.utility.EnvironmentUtil;

public class DBConnection {
	
	public static Connection getConnectionToDatabase() {
		String url = EnvironmentUtil.getPropertyValue("dbConnection.url") + "?serverTimezone=" + TimeZone.getDefault().getID();
		String uname = EnvironmentUtil.getPropertyValue("dbConnection.username");
		String pwd = EnvironmentUtil.getPropertyValue("dbConnection.password");
		
		Connection connection = null;

		try {

			// load the driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("MySQL JDBC Driver Registered!");

			// get hold of the DriverManager
			connection = DriverManager.getConnection(url, uname, pwd);
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();

		}

		if (connection != null) {
			System.out.println("Connection made to DB!");
		}
		return connection;
		
	}

}
