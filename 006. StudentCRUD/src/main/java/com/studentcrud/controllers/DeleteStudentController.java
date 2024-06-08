package com.studentcrud.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.studentcrud.daoimpl.StudentDAOImpl;

/**
 * Servlet implementation class DeleteStudentController
 */

public class DeleteStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentDAOImpl studentDAOImpl;

	public DeleteStudentController() {
		super();
		studentDAOImpl = new StudentDAOImpl();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			int result = studentDAOImpl.remove(id);
			if(result>0) {
				printWriter.println("<h3>Student Deleted</h3>");
				response.sendRedirect("StudentController");
			}
			else {
				printWriter.println("<h3>Failed to delete student</h3>");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			printWriter.println("<h3>Something went wrong...</h3>");
		}

	}

}
