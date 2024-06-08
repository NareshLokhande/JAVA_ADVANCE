package com.studentcrud.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.studentcrud.daoimpl.StudentDAOImpl;
import com.studentcrud.models.Student;

/**
 * Servlet implementation class DeleteStudentController
 */

public class UpdateStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentDAOImpl studentDAOImpl;

	public UpdateStudentController() {
		super();
		studentDAOImpl = new StudentDAOImpl();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();

		try {
			String idstr = request.getParameter("id");
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String marksstr = request.getParameter("marks");
            String city = request.getParameter("city");
            String gender = request.getParameter("gender");

			if (isNullOrEmpty(idstr) || isNullOrEmpty(name) || isNullOrEmpty(phone) || 
	                isNullOrEmpty(marksStr) || isNullOrEmpty(city) || isNullOrEmpty(gender)) {
	                printWriter.println("<h3>All fields are required!</h3>");
	                return;
	            }

			int id = Integer.parseInt(id.trim());
            float marks = Float.parseFloat(marks.trim());
            
			Student student = new Student();
			student.setId(id);
            student.setName(name.trim());
            student.setPhone(phone.trim());
            student.setMarks(marks);
            student.setCity(city.trim());
            student.setGender(gender.trim());

			int result = studentDAOImpl.update(id, student);
			if (result > 0) {
				printWriter.println("<h3>Student Updated</h3>");
				response.sendRedirect("StudentController");
			} else {
				printWriter.println("<h3>Failed to update student info</h3>");
			}

		} catch (Exception e) {
			e.printStackTrace();
			printWriter.println("<h3>Something went wrong...</h3>");
		}

	}
	
	private boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

}
