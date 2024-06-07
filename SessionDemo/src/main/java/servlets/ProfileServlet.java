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
 * Servlet implementation class NewProfileServlet
 */
public class ProfileServlet extends HttpServlet {
	
	final static String DB_USER = "root";
	final static String DB_PASSWORD = "cdac";
	final static String DB_NAME = "school";
	final static String DB_URL = "jdbc:mysql://localhost:3306/" + DB_NAME;
	final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfileServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter printwriter = response.getWriter();
		
		HttpSession session = request.getSession(false); // to get the existing session we must pass false as argument
		try {
			
			if (session != null) {
				String username = (String) session.getAttribute("usernameSession");
				Class.forName(JDBC_DRIVER);
				Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				Statement stmt = conn.createStatement();
				String qry = "SELECT * FROM user WHERE username='"+username+"'";
				ResultSet rs = stmt.executeQuery(qry);
				
				if (rs.next()) {
					int id = rs.getInt("id");
					String phone = rs.getString("phone");
					String email = rs.getString("email");
					printwriter.println("<h3> Welcome " + username + "</h3>");
					printwriter.println("<h4> ID : " + id + "</h4>");
					printwriter.println("<h4> PHONE : " + phone + "</h4>");
					printwriter.println("<h4> EMAIL : " + email + "</h4>");
					printwriter.println("<a href='LogoutServlet' > Logout </a>");
				} else {
					System.out.println("<h3>User not found</h3>");
				}
			} else {
				response.sendRedirect("index.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
