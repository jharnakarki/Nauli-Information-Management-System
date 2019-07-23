package com.naulitraders.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.naulitraders.model.TruckInfo;

public class ApplicationDao {

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

}
