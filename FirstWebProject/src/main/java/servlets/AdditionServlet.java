package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class AdditionServlet
 */
public class AdditionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		int a = Integer.parseInt(request.getParameter("n1"));
		int b = Integer.parseInt(request.getParameter("n2"));
		int c = a+b;
		System.out.println("Sum is : "+c);
		PrintWriter out = response.getWriter();
		out.println("<h1>Sum is "+c+"</h1>");
		}

}
