package com.cdac.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signup.cdac")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String dob = request.getParameter("dob");
		String city = request.getParameter("city");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// JDBC code
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdac", "root", "cdac");

			String qry = "INSERT into users(name, dob, city, email, password) values (?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(qry);

			pstmt.setString(1, name);
			pstmt.setString(2, dob);
			pstmt.setString(3, city);
			pstmt.setString(4, email);
			pstmt.setString(5, password);

			int rowsAffected = pstmt.executeUpdate();
			
			if (rowsAffected > 0) {
				response.getWriter().println("Signup successful!");
			} else {
				response.getWriter().println("Signup failed. Please try again.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
