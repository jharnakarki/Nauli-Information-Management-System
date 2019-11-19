package com.naulitraders.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.naulitraders.model.EmployeeInfo;
import com.naulitraders.model.TruckInfo;

public class TruckDao {

	public void insertTruckInfo(TruckInfo truckInfo) {

		String sql = "insert into tckInfo(vehNumber,brand,model,capacity,tyres,year,status) values(?,?,?,?,?,?,?)";

		try {
			Connection con = DBConnection.getConnectionToDatabase();

			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, truckInfo.getTruckNumber());
			pst.setString(2, truckInfo.getBrand());
			pst.setInt(3, truckInfo.getModel());
			pst.setInt(4, truckInfo.getCapacity());
			pst.setInt(5, truckInfo.getTyres());
			pst.setInt(6, truckInfo.getYear());
			pst.setString(7, truckInfo.getStatus());
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<TruckInfo> getTrucksList() {

		List<TruckInfo> listOfTrucks = new ArrayList<>();

		String sql = "SELECT vehNumber, brand, model, capacity, tyres, year, status FROM tckInfo order by status ASC ";

		Statement statement;

		try {
			Connection conn = DBConnection.getConnectionToDatabase();

			statement = conn.createStatement();

			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				TruckInfo truckInfo = new TruckInfo();

				truckInfo.setTruckNumber(rs.getString("vehNumber"));
				truckInfo.setBrand(rs.getString("brand"));
				truckInfo.setModel(rs.getInt("model"));
				truckInfo.setCapacity(rs.getInt("capacity"));
				truckInfo.setTyres(rs.getInt("tyres"));
				truckInfo.setYear(rs.getInt("year"));
				truckInfo.setStatus(rs.getString("status"));
				listOfTrucks.add(truckInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfTrucks;
	}

	// for displaying only active truck list
	public List<TruckInfo> getActiveTrucksList() {

		List<TruckInfo> listOfActiveTrucks = new ArrayList<>();

		String sql = "SELECT vehNumber, brand, model, capacity, tyres, year, status FROM tckInfo where status='Active' ";

		Statement statement;

		try {
			Connection conn = DBConnection.getConnectionToDatabase();

			statement = conn.createStatement();

			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				TruckInfo truckInfo = new TruckInfo();

				truckInfo.setTruckNumber(rs.getString("vehNumber"));
				truckInfo.setBrand(rs.getString("brand"));
				truckInfo.setModel(rs.getInt("model"));
				truckInfo.setCapacity(rs.getInt("capacity"));
				truckInfo.setTyres(rs.getInt("tyres"));
				truckInfo.setYear(rs.getInt("year"));
				truckInfo.setStatus(rs.getString("status"));
				listOfActiveTrucks.add(truckInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfActiveTrucks;
	}

	// for displaying only Inactive truck list
	public List<TruckInfo> getInActiveTrucksList() {

		List<TruckInfo> listOfInActiveTrucks = new ArrayList<>();

		String sql = "SELECT vehNumber, brand, model, capacity, tyres, year, status FROM tckInfo where status='InActive' ";

		Statement statement;

		try {
			Connection conn = DBConnection.getConnectionToDatabase();

			statement = conn.createStatement();

			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				TruckInfo truckInfo = new TruckInfo();

				truckInfo.setTruckNumber(rs.getString("vehNumber"));
				truckInfo.setBrand(rs.getString("brand"));
				truckInfo.setModel(rs.getInt("model"));
				truckInfo.setCapacity(rs.getInt("capacity"));
				truckInfo.setTyres(rs.getInt("tyres"));
				truckInfo.setYear(rs.getInt("year"));
				truckInfo.setStatus(rs.getString("status"));
				listOfInActiveTrucks.add(truckInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfInActiveTrucks;
	}




	// for updating the truck detail
	public void updateTruck(TruckInfo truckInfo) {
		String sql = "UPDATE  tckInfo SET status= ? WHERE vehNumber = ?";

		try {
			Connection conn = DBConnection.getConnectionToDatabase();

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, truckInfo.getStatus());
			pst.setString(2, truckInfo.getTruckNumber());
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public TruckInfo getTruckDetail(String truckNumber) {
		TruckInfo truckInfo = null;

		String sql = "SELECT vehNumber, brand, model, capacity, tyres, year, status FROM tckInfo WHERE vehNumber =? ";

		try {
			Connection conn = DBConnection.getConnectionToDatabase();

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, truckNumber);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				truckInfo = new TruckInfo();

				truckInfo.setTruckNumber(rs.getString("vehNumber"));
				truckInfo.setBrand(rs.getString("brand"));
				truckInfo.setModel(rs.getInt("model"));
				truckInfo.setCapacity(rs.getInt("capacity"));
				truckInfo.setTyres(rs.getInt("tyres"));
				truckInfo.setYear(rs.getInt("year"));
				truckInfo.setStatus(rs.getString("status"));

				// it should be only one result, so break out of loop
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return truckInfo;
	}

	// validation for unique truck number
	public boolean isNumberAlreadyExist(String number) {

		String sql = "SELECT vehNumber FROM tckInfo WHERE vehNumber = ?";

		try {
			Connection conn = DBConnection.getConnectionToDatabase();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, number);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				// truck number already exist
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
