package com.naulitraders.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.naulitraders.model.EmployeeInfo;
import com.naulitraders.model.TripInfo;

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
	
	
	public void updateEmployee(EmployeeInfo employeeInfo) {
		String sql = "UPDATE  Employee SET name = ?,position = ?,phoneNumber = ?,salary = ? FROM Employee WHERE empId = ?";
		
		try {
			Connection conn = DBConnection.getConnectionToDatabase();
			
			PreparedStatement  pst = conn.prepareStatement(sql);
			
			
			pst.setString(1, employeeInfo.getName());
			pst.setString(2, employeeInfo.getPosition());
			pst.setLong(3, employeeInfo.getPhoneNumber());
			pst.setDouble(4,employeeInfo.getSalary());
			pst.setInt(5, employeeInfo.getEmpId());
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public EmployeeInfo getEmployee(int empId) {
		EmployeeInfo employeeInfo = null;
		
		String sql = "SELECT name,position,phoneNumber,salary FROM Employee  WHERE empId =?";
		
		try {
			Connection conn = DBConnection.getConnectionToDatabase();
			
			PreparedStatement  pst = conn.prepareStatement(sql);
			pst.setInt(1, empId);
			
			ResultSet rs = pst.executeQuery();
			
			
			while(rs.next()) {
				 employeeInfo = new  EmployeeInfo();
				
				 employeeInfo.setEmpId(rs.getInt("empId"));
				 employeeInfo.setName(rs.getString("name"));
				 employeeInfo.setPosition(rs.getString("position"));
				 employeeInfo.setPhoneNumber(rs.getLong("phoneNumber"));
				 employeeInfo.setSalary(rs.getDouble("salary"));
				 
			// it should be only one result, so break out of loop
				break;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return employeeInfo;
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
