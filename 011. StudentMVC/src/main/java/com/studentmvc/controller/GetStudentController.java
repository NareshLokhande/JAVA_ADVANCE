package com.studentmvc.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.studentmvc.model.Student;
import com.studentmvc.serviceimpl.StudentServiceImpl;


public class GetStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public GetStudentController() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentServiceImpl impl = new StudentServiceImpl();
        List<Student> students = impl.getAll();
        request.setAttribute("studentsList", students);
        RequestDispatcher dispatcher = request.getRequestDispatcher("jstl-demo.jsp");
        dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
