package com.JDBC.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertData4 {

	public static void main(String[] args) {

		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdac", "root", "cdac");

			// Prepared statement
			String qry = "INSERT INTO tbl_product(name, price, quantity) VALUES (?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(qry);
			stmt.setString(1, "Oppo F20");
			stmt.setDouble(2, 20000);
			stmt.setInt(3, 25);
			stmt.executeUpdate();
			
			System.out.println("Record Inserted !!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
