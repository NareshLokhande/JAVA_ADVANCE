package com.JDBC.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertData {
	
	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdac", "root", "cdac");
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO tbl_product(name, price, quantity) VALUES ('Samsung s24', 40000, 10)");
			System.out.println("Record inserted ..");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
