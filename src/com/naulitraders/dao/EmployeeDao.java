package com.naulitraders.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.naulitraders.model.EmployeeInfo;

public class EmployeeDao {

	public void insertEmployeeInfo(EmployeeInfo employeeInfo) {
		String sql = "insert into Employee(name,position,phoneNumber,salary) values(?,?,?,?)";

		try {
			Connection con = DBConnection.getConnectionToDatabase();

			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, employeeInfo.getName());
			pst.setString(2, employeeInfo.getPosition());
			pst.setString(3, employeeInfo.getPhoneNumber());
			pst.setDouble(4, employeeInfo.getSalary());
			
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
