package com.JDBC.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class InsertData3 {

	public static void main(String[] args) {

		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdac", "root", "cdac");
			Statement stmt = conn.createStatement();

			Scanner sc = new Scanner(System.in);
			String ans = "";
			do {
				System.out.print("Product Name: ");
				String name = sc.nextLine();
				System.out.print("Product Price: ");
				double price = Double.parseDouble(sc.nextLine());
				System.out.print("Product Quantity: ");
				int qty = Integer.parseInt(sc.nextLine());

				String qry = "INSERT INTO tbl_product(name, price, quantity) VALUES ('" + name + "', " + price + ","
						+ qty + ")";
				System.out.println(qry);

				stmt.executeUpdate(qry);
				System.out.println("Record inserted ..");
				System.out.println("Continue ? (y/n)");
				ans = sc.nextLine();

			} while (ans.equals("y"));

			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
