package com.naulitraders.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.naulitraders.model.EmployeeInfo;

public class EmployeeDao{

	public void insertEmployeeInfo(EmployeeInfo employeeInfo) {

		String sql = "insert into Employee(name,age,address,phone,position,salary) values(?,?,?,?,?,?)";

		try {
			Connection con = DBConnection.getConnectionToDatabase();

			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, employeeInfo.getName());
			pst.setInt(2,employeeInfo.getAge());
			pst.setString(3, employeeInfo.getAddress());
			pst.setInt(4,employeeInfo.getContact());
			pst.setString(5,employeeInfo.getPosition());
			pst.setDouble(6,employeeInfo.getSalary());
			pst.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
