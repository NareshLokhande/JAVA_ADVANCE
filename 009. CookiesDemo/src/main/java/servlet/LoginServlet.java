package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
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

		PrintWriter printWriter = response.getWriter();
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			if (username.equals("admin") && password.equals("admin123")) {
				Cookie ck = new Cookie("usernameCookie", username);
				ck.setMaxAge(200);
				response.addCookie(ck);
				response.sendRedirect("ProfileServlet");

			} else {
				printWriter.println("<script>alert('Invalied Creadentials')</script>");
				printWriter.println("<script>location.href='index.html'</script>");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
