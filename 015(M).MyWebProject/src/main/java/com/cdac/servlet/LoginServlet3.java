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


@WebServlet("/login3.cdac")
public class LoginServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email  = request.getParameter("email");
		String password = request.getParameter("password");

		//JDBC code
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdac", "root", "cdac");
			
			String qry = "SELECT count(id) FROM users WHERE email=? and password=?";
			PreparedStatement pstmt = conn.prepareStatement(qry);
			
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				int count = rs.getInt(1); 
				if(count == 1) {
					String rememberMe = request.getParameter("rememberMe");
					if(rememberMe != null && rememberMe.equals("yes")) {
						String data = Base64.getEncoder().encode((email+ ":" +password).getBytes()).toString();
						Cookie ck = new Cookie("logindata", data);
						ck.setMaxAge(60*60*24); // seconds
						response.addCookie(ck); 
					}
					response.sendRedirect("welcome.html");
				}
				else
					response.sendRedirect("login.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
