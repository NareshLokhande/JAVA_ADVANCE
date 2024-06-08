package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	final static String DB_USER = "root";
	final static String DB_PASSWORD = "cdac";
	final static String DB_NAME = "school";
	final static String DB_URL = "jdbc:mysql://localhost:3306/" + DB_NAME;
	final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printwriter = response.getWriter();
		try {
			Class.forName(JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			Statement stmt = conn.createStatement();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String qry = "SELECT * FROM user WHERE username='" + username + "' and password='" + password + "'";
			ResultSet rs = stmt.executeQuery(qry);

			if (rs.next()) {
				HttpSession session =  request.getSession();	//create a new session and create object for newly created session
				session.setAttribute("usernameSession", username);		// it will store the data in a key value pair
				response.sendRedirect("ProfileServlet");
				
			} else {
				printwriter.println("<script>alert('Invalid credentials')</script>");
				printwriter.println("<script>location.href='index.html'</script>");
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

}
