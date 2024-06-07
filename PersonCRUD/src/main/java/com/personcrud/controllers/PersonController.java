package com.personcrud.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import com.personcrud.daoimpl.PersonDAOImpl;
import com.personcrud.models.Person;

public class PersonController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PersonDAOImpl personDAOImpl;

	public PersonController() {
		personDAOImpl = new PersonDAOImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();

		try {

			List<Person> personsList = personDAOImpl.getall();

			printWriter.println("<table border='1' cellspacing='0' cellpadding='10'>");
			printWriter.println("<tr>");
			printWriter.println("<th>ID<th>");
			printWriter.println("<th>Name<th>");
			printWriter.println("<th>DOB<th>");
			printWriter.println("<th>Action</th>");
			printWriter.println("<th>Action</th>");
			printWriter.println("<tr>");

			for (Person person : personsList) {
				printWriter.println("<tr>");
				printWriter.println("<td>" + person.getId_person() + "</td>");
				printWriter.println("<td>" + person.getName_person() + "</td>");
				printWriter.println("<td>" + new SimpleDateFormat("yyyy-MM-dd").format(person.getDob()) + "</td>");
				printWriter.println(
						"<td><a href='DeletePersonController?id=" + person.getId_person() + "'>Delete</a></td>");
				printWriter.println(
						"<td><a href='UpdatePersonController?id=" + person.getId_person() + "'>Update</a></td>");
				printWriter.println("<tr>");
			}
			
			printWriter.println("</table>");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			printWriter.println("<h3>Something Went Wrong</h3>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();

        try {
            String namePerson = request.getParameter("name_person");
            String dobStr = request.getParameter("dob");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dob = dateFormat.parse(dobStr);

            Person person = new Person();
            person.setName_person(namePerson);
            person.setDob((Date) dob);

            int result = personDAOImpl.save(person);
            if (result > 0) {
                printWriter.println("<h3>Person Registered</h3>");
            } else {
                printWriter.println("<h3>Person Registration failed</h3>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            printWriter.println("<h3>Something Went Wrong....</h3>");
        } finally {
            printWriter.close();
        }
	}
}

