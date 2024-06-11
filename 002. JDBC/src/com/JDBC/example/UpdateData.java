package com.JDBC.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateData {

	public static void main(String[] args) {

		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdac", "root", "cdac");
			// Prepared statement
			String qry = "UPDATE tbl_product SET price=?, quantity=? WHERE name=?";
			
			PreparedStatement stmt = conn.prepareStatement(qry);
			Scanner sc = new Scanner(System.in);
			String ans = "";
			
			System.out.println("Update Product");
			do {
				System.out.print("Product Name: ");
				String name = sc.nextLine();
				System.out.print("Product Price: ");
				double price = Double.parseDouble(sc.nextLine());
				System.out.print("Product Quantity: ");
				int qty = Integer.parseInt(sc.nextLine());

			stmt.setDouble(1, price);
			stmt.setInt(2, qty);
			stmt.setString(3, name);
			stmt.executeUpdate();
			
			System.out.println(name+ " is Updated !!");
			System.out.println("Continue ? (y/n)");
			ans = sc.nextLine();

		} while (ans.equals("y"));

			
		sc.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
