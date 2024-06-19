package com.cdac.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/login.cdac")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//read the form data 
		String username  = request.getParameter("username");
		String password = request.getParameter("password");
		
		//Now we will go and check  in the database
		//Lets do it hardcore
		if(username.equals("naresh") && password.equals("cdac"))
			response.sendRedirect("welcome.html");
		else
			response.sendRedirect("login.html");
	}

}
