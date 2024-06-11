package com.JDBC.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertData5 {

	public static void main(String[] args) {

		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdac", "root", "cdac");

			// Prepared statement
			String qry = "INSERT INTO tbl_product(name, price, quantity) VALUES (?, ?, ?)";
			
			PreparedStatement stmt = conn.prepareStatement(qry);
			Scanner sc = new Scanner(System.in);
			String ans = "";
			
			do {
				System.out.print("Product Name: ");
				String name = sc.nextLine();
				System.out.print("Product Price: ");
				double price = Double.parseDouble(sc.nextLine());
				System.out.print("Product Quantity: ");
				int qty = Integer.parseInt(sc.nextLine());

			stmt.setString(1, name);
			stmt.setDouble(2, price);
			stmt.setInt(3, qty);
			stmt.executeUpdate();
			
			System.out.println(name+ " is inserted !!");
			System.out.println("Continue ? (y/n)");
			ans = sc.nextLine();

		} while (ans.equals("y"));

		sc.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
