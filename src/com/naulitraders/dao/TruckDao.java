package com.naulitraders.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.naulitraders.model.TruckInfo;

public class TruckDao {

	public void insertTruckInfo(TruckInfo truckInfo) {
		
		String sql = "insert into tckInfo(vehNumber,brand,model,capacity,tyres,year) values(?,?,?,?,?,?)";

		try {
			Connection con = DBConnection.getConnectionToDatabase();

			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, truckInfo.getTruckNumber());
			pst.setString(2, truckInfo.getBrand());
			pst.setInt(3, truckInfo.getModel());
			pst.setInt(4, truckInfo.getCapacity());
			pst.setInt(5, truckInfo.getTyres());
			pst.setInt(6, truckInfo.getYear());
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<TruckInfo> getTrucksList() {
		
		List<TruckInfo> listOfTrucks = new ArrayList<>();
		
		String sql = "SELECT vehNumber, brand, model, capacity, tyres, year FROM tckInfo";
		
		Statement statement;
		
		try {
			Connection conn = DBConnection.getConnectionToDatabase();
			
			statement = conn.createStatement();
			
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				TruckInfo truckInfo = new TruckInfo();
				
				truckInfo.setTruckNumber(rs.getString("vehNumber"));
				truckInfo.setBrand(rs.getString("brand"));
				truckInfo.setModel(rs.getInt("model"));
				truckInfo.setCapacity(rs.getInt("capacity"));
				truckInfo.setTyres(rs.getInt("tyres"));
				truckInfo.setYear(rs.getInt("year"));
				
				listOfTrucks.add(truckInfo);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return listOfTrucks;
	}

}
