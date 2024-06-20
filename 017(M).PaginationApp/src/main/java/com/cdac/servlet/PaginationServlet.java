package com.cdac.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.cdac.jdbc.Product;
import com.cdac.jdbc.ProductDataLoader;

@WebServlet("/pagination.cdac")
public class PaginationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	int offset;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String move = request.getParameter("move");

		if (move != null) {
			if (move.equals("next"))
				offset += 5;
			else if (move.equals("prev"))
				offset -= 5;
		}

		ProductDataLoader loader = new ProductDataLoader();
		List<Product> list = loader.loadProducts(offset);
		
		HttpSession session = request.getSession();
		session.setAttribute("listOfProducts", list);

		response.sendRedirect("pagination4.jsp");
	}

}
