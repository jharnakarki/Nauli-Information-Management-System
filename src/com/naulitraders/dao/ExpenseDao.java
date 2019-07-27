package com.naulitraders.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import com.naulitraders.model.ExpenseInfo;

public class ExpenseDao {

	public void insertExpenseInfo(ExpenseInfo expenseInfo) {

		String sql = "insert into expenses(vehNum,dates,amount,bill,remarks) values(?,?,?,?,?)";

		try {
			Connection con = DBConnection.getConnectionToDatabase();

			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, expenseInfo.getTruckNumber());
			pst.setDate(2, Date.valueOf(expenseInfo.getExpDate()));
			pst.setDouble(3, expenseInfo.getAmount());
			pst.setBlob(4, expenseInfo.getInputStream());
			pst.setString(5,expenseInfo.getRemarks());
			
			pst.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

