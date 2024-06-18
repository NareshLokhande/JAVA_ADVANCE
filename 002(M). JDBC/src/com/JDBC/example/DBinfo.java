package com.JDBC.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBinfo {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			//Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Establish connection with the database
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdac","root","cdac");
			System.out.println("Connection Successfull !!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
