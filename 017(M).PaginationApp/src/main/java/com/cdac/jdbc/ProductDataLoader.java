package com.cdac.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDataLoader {
	
	public List<Product> loadProducts(int offset) {
		//JDBC code
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdac", "root", "cdac");

			String qry = "SELECT * FROM tbl_product limit 5 offset ?";
			PreparedStatement pstmt = conn.prepareStatement(qry);
			pstmt.setInt(1, offset);
			ResultSet rs = pstmt.executeQuery();

			List<Product> list = new ArrayList<>();
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				double price = rs.getDouble(3);
				int quantity = rs.getInt(4);
				
				Product p = new Product(id, name, price,quantity);
				list.add(p);
			}
			rs.close();
			pstmt.close();
			conn.close();
			return list;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
	}
}
