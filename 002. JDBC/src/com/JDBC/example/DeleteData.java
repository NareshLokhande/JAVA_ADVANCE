package com.JDBC.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteData {

	public static void main(String[] args) {

		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdac", "root", "cdac");
			// Prepared statement
			String qry = "DELETE FROM tbl_product WHERE id=?";
			
			PreparedStatement stmt = conn.prepareStatement(qry);
			Scanner sc = new Scanner(System.in);
			String ans = "";
			
			System.out.println("Delete Product");
			do {
				System.out.print("Product ID: ");
				int id = sc.nextInt();
				sc.nextLine();
				
				stmt.setInt(1, id);
				stmt.executeUpdate();
				
				System.out.println("Record " +id+" Deleted !!");
				System.out.println("Continue ? (y/n)");
				ans = sc.nextLine();
			} while (ans.equals("y"));
			
		sc.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
