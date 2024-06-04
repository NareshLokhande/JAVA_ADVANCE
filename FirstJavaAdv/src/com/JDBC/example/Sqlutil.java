package com.JDBC.example;

import java.sql.*;

public class Sqlutil {
	final static String DB_USER = "root";
	final static String DB_PASSWROD = "cdac";
	final static String DB_NAME = "cdac_java";
	final static String DB_URL = "jdbc:mysql://localhost:3306/"+DB_NAME;
	final static String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	
	static void connectDb() {
		try{
			Class.forName(DRIVER_CLASS);
			Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWROD)
			Statement stmt  = conn.createStatement();
		}catch (Exception ex) {
			System.out.println(ex);
		}
		
	}
	
	void insert(String qry) {
		int rerult = -1;
		try {
			result = stmt.executeUpdate(qry);
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

}
