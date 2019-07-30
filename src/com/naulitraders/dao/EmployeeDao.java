package com.naulitraders.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.naulitraders.model.EmployeeInfo;

public class EmployeeDao {

	public void insertEmployeeInfo(EmployeeInfo employeeInfo) {
		String sql = "insert into Employee(name,position,phoneNumber,salary) values(?,?,?,?)";

		try {
			Connection con = DBConnection.getConnectionToDatabase();

			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, employeeInfo.getName());
			pst.setString(2, employeeInfo.getPosition());
			pst.setLong(3, employeeInfo.getPhoneNumber());
			pst.setDouble(4, employeeInfo.getSalary());
			
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public List<EmployeeInfo> getEmployeesList() {



		List<EmployeeInfo> listOfEmployees = new ArrayList<>();



		String sql = "SELECT name,position,phoneNumber,salary FROM Employee";



		Statement statement;



		try {

		Connection conn = DBConnection.getConnectionToDatabase();



		statement = conn.createStatement();



		ResultSet rs = statement.executeQuery(sql);

		while (rs.next()) {

		EmployeeInfo employeeInfo = new EmployeeInfo();



		employeeInfo.setName(rs.getString("name"));

		employeeInfo.setPosition(rs.getString("position"));

		employeeInfo.setPhoneNumber(rs.getLong("phoneNumber"));

		employeeInfo.setSalary(rs.getDouble("salary"));

		listOfEmployees.add(employeeInfo);

		}

		} catch (SQLException e) {

		e.printStackTrace();

		}

		return listOfEmployees;

		}

}
