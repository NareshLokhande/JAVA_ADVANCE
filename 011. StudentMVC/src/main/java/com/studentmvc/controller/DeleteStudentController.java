package com.studentmvc.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.studentmvc.serviceimpl.StudentServiceImpl;

public class DeleteStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       StudentServiceImpl studentServiceImpl;
       

    public DeleteStudentController() {
        super();
        studentServiceImpl = new StudentServiceImpl();
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			int id = Integer.parseInt(request.getParameter("id"));
			int result = studentServiceImpl.remove(id);
			
			request.setAttribute("studentsList", studentServiceImpl.getAll());
			RequestDispatcher rd = request.getRequestDispatcher("student-list.jsp");
			if (result > 0) {
				request.setAttribute("msg", "Student Deleted !");
			} else {
				request.setAttribute("errorMsg", "Problem in Deletion !");
			}
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
