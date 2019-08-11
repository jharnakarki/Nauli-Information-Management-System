package com.naulitraders.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	
	public boolean validateUser(String username,String password) {
			
		try {
			Connection conn = DBConnection.getConnectionToDatabase();
			String sql = "SELECT username,password FROM admins WHERE username = ? and password=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1,username);
			pst.setString(2,password);
			
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				// employee with that phone number already exist
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
