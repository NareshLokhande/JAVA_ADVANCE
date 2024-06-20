<%@page import="com.cdac.jdbc.Product"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>

<%@page import="java.util.List"%>
<%@page import="com.cdac.jdbc.ProductDataLoader"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pagination</title>

<link rel="stylesheet" href="pagination.css">

</head>
<body>

	<%!int offset = 0;%>

	<%
	//Passing parameter in url
		String move = request.getParameter("move");
		//Add the boundry condition for next and prev
		if (move != null) {
			if (move.equals("next"))
				offset += 5;
			else if (move.equals("prev"))
				offset -= 5;
		}
	
	ProductDataLoader loader = new ProductDataLoader();
	List<Product> list = loader.loadProducts(offset);
	for(Product product : list){
	%>
	<div class="card">
		<div class="container">
			<h4>
				<b><%=product.getId()%></b>
			</h4>
			<p><%=product.getQuantity()%></p>
			<p><%=product.getPrice()%></p>
			<p><%=product.getQuantity()%></p>
		</div>
	</div>
	
<%
	}
%>

	<div class="card-links">
		<a href="pagination3.jsp?move=prev ">Previous</a> <a
			href="pagination3.jsp?move=next">Next</a>
	</div>

</body>
</html>