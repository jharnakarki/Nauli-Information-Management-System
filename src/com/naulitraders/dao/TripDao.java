package com.naulitraders.dao;
import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.naulitraders.model.TripInfo;

public class TripDao {

	public void insertTripInfo(TripInfo tripInfo) {

		String sql = "insert into trip(vehNum,stDate,edDate,maStart,maEng,origin,mulDes,rev,dName,remarks)"
				+ " values(?,?,?,?,?,?,?,?,?,?)";

		try {
			Connection con = DBConnection.getConnectionToDatabase();
			

			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, tripInfo.getTruckNumber());
			pst.setDate(2, tripInfo.getStartDate());
			pst.setDate(3, tripInfo.getEndDate());
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

}