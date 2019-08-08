package com.naulitraders.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.naulitraders.model.AdminInfo;

public class AdminDao {

	public void insertAdminInfo(AdminInfo adminInfo) {
		String sql = "insert into admins(username,password) values(?,?)";

		try {
			Connection con = DBConnection.getConnectionToDatabase();

			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, adminInfo.getUsername());
			pst.setString(2, adminInfo.getPassword());
			
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//validation for unique admin name
	public boolean isAdminAlreadyExist(String name) {

		String sql = "SELECT username FROM admins WHERE username = ?";

		try {
			Connection conn = DBConnection.getConnectionToDatabase();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, name);

			ResultSet rs = pst.executeQuery();

			while(rs.next()) {
				// admin with that name already exist
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}