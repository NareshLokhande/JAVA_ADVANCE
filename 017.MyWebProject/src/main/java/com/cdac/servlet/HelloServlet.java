package com.cdac.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hello.cdac")	//URL pattern or servlet mapping
public class HelloServlet extends HttpServlet {

@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter out = response.getWriter();
			out.write("<html><body>");
			out.write("<h1>Welcome to Servlet </h1>");
			LocalDate date = LocalDate.now();
			out.write("<h2> Today's Date is :" +date+ "</h2>");
			out.write("</body></html>");
		}
	}
