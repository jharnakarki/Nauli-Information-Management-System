package com.naulitraders.dao;

import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import com.naulitraders.model.TripInfo;

public class TripDao {

	public void insertTripInfo(TripInfo tripInfo) {

		String sql = "insert into trip(vehNumber,dtStart,dtEnd,maStart,maEnd,origin,mulDes,rev,dName,remarks)"
				+ " values(?,?,?,?,?,?,?,?,?,?)";

		try {
			Connection con = DBConnection.getConnectionToDatabase();

			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, tripInfo.getTruckNumber());
			pst.setDate(2, Date.valueOf(tripInfo.getStartDate()));
			pst.setDate(3, Date.valueOf(tripInfo.getEndDate()));
			pst.setInt(4, tripInfo.getStartMileage());
			pst.setInt(5, tripInfo.getEndMileage());
			pst.setString(6, tripInfo.getOrigin());
			pst.setString(7, tripInfo.getMulDestination());
			pst.setDouble(8, tripInfo.getRevenue());
			pst.setString(9, tripInfo.getDriverName());
			pst.setString(10, tripInfo.getRemarks());

			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateTrip(TripInfo tripInfo) {
		String sql = "UPDATE trip SET dtStart = ?,  dtEnd = ?, maStart = ?, maEnd = ?, origin = ?, mulDes = ?, rev = ?, dName = ?, remarks = ? WHERE tripId = ?";
		
		try {
			Connection conn = DBConnection.getConnectionToDatabase();
			
			PreparedStatement  pst = conn.prepareStatement(sql);
			pst.setDate(1, Date.valueOf(tripInfo.getStartDate()));
			pst.setDate(2, Date.valueOf(tripInfo.getEndDate()));
			pst.setInt(3, tripInfo.getStartMileage());
			pst.setInt(4, tripInfo.getEndMileage());
			pst.setString(5, tripInfo.getOrigin());
			pst.setString(6, tripInfo.getMulDestination());
			pst.setDouble(7, tripInfo.getRevenue());
			pst.setString(8, tripInfo.getDriverName());
			pst.setString(9, tripInfo.getRemarks());
			pst.setInt(10, tripInfo.getTripId());
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public TripInfo getTrip(int tripId) {
		TripInfo tripInfo = null;
		
		String sql = "SELECT tripID, vehNumber,dtStart,dtEnd,maStart,maEnd,origin,mulDes,rev,dName,remarks FROM trip WHERE tripID = ?";
		
		try {
			Connection conn = DBConnection.getConnectionToDatabase();
			
			PreparedStatement  pst = conn.prepareStatement(sql);
			pst.setInt(1, tripId);
			
			ResultSet rs = pst.executeQuery();
			
			
			while(rs.next()) {
				tripInfo = new TripInfo();
				
				tripInfo.setTripId(rs.getInt("tripID"));
				tripInfo.setTruckNumber(rs.getString("vehNumber"));
				tripInfo.setStartDate(rs.getDate("dtStart").toLocalDate());
				tripInfo.setEndDate(rs.getDate("dtEnd").toLocalDate());
				tripInfo.setStartMileage(rs.getInt("maStart"));
				tripInfo.setEndMileage(rs.getInt("maEnd"));
				tripInfo.setOrigin(rs.getString("origin"));
				tripInfo.setMulDestination(rs.getString("mulDes"));
				tripInfo.setRevenue(rs.getDouble("rev"));
				tripInfo.setDriverName(rs.getString("dName"));
				tripInfo.setRemarks(rs.getString("remarks"));
				// it should be only one result, so break out of loop
				break;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return tripInfo;
	}
	
	public List<TripInfo> getTrips(String vehNumber, LocalDate tripStartDate, LocalDate tripEndDate) {
		
		List<TripInfo> listOfTrips = new ArrayList<>();
		
		String sql = "SELECT dtEnd, rev FROM trip WHERE vehNumber = ? AND dtStart >= ? AND dtEnd <= ?";
		
		PreparedStatement pst;
		
		try {
			Connection conn = DBConnection.getConnectionToDatabase();
			
			pst = conn.prepareStatement(sql);
			pst.setString(1, vehNumber);
			pst.setDate(2, Date.valueOf(tripStartDate));
			pst.setDate(3, Date.valueOf(tripEndDate));
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				
				TripInfo tripInfo = new TripInfo();
				tripInfo.setEndDate(rs.getDate("dtEnd").toLocalDate());
				tripInfo.setRevenue(rs.getDouble("rev"));

				listOfTrips.add(tripInfo);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return listOfTrips;
	}
	
	public List<TripInfo> getTripsList() {

		List<TripInfo> listOfTrips = new ArrayList<>();

		String sql = "SELECT tripID, vehNumber,dtStart,dtEnd,maStart,maEnd,origin,mulDes,rev,dName,remarks FROM trip order by dtStart DESC";

		Statement statement;

		try {
			Connection conn = DBConnection.getConnectionToDatabase();

			statement = conn.createStatement();

			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				TripInfo tripInfo = new TripInfo();

				tripInfo.setTripId(rs.getInt("tripID"));
				tripInfo.setTruckNumber(rs.getString("vehNumber"));
				tripInfo.setStartDate(rs.getDate("dtStart").toLocalDate());
				tripInfo.setEndDate(rs.getDate("dtEnd").toLocalDate());
				tripInfo.setStartMileage(rs.getInt("maStart"));
				tripInfo.setEndMileage(rs.getInt("maEnd"));
				tripInfo.setOrigin(rs.getString("origin"));
				tripInfo.setMulDestination(rs.getString("mulDes"));
				tripInfo.setRevenue(rs.getDouble("rev"));
				tripInfo.setDriverName(rs.getString("dName"));
				tripInfo.setRemarks(rs.getString("remarks"));

				listOfTrips.add(tripInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfTrips;
	}
		

}
