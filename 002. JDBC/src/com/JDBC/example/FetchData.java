package com.JDBC.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class FetchData {

	public static void main(String[] args) {

		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdac", "root", "cdac");

			// Prepared statement
			String qry = "SELECT * FROM tbl_product WHERE price >=?";
			
			PreparedStatement stmt = conn.prepareStatement(qry);
			Scanner sc = new Scanner(System.in);
			System.out.println("Display products bases on Price");
			System.out.println("Enter Price: ");
			double baseprice = sc.nextDouble();
			
			stmt.setDouble(1, baseprice);
			
			ResultSet rs = stmt.executeQuery();	//for select operations
			
			//Output
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				int quantity = rs.getInt("quantity");
				System.out.println(id + "," + name + "," + price + "," + quantity);
			}

		sc.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
