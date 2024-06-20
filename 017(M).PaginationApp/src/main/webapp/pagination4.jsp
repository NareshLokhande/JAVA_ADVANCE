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
<%
	List<Product> list = ( List<Product> )session.getAttribute("listOfProducts");
	if (list == null || list.isEmpty()) {
%>
    <p>No products available.</p>
<%
    } else {
        for (Product product : list) {
%>

	<div class="card">
		<div class="container">
			<h4><b><%=product.getId()%></b></h4>
			<p><%=product.getQuantity()%></p>
			<p><%=product.getPrice()%></p>
			<p><%=product.getQuantity()%></p>
		</div>
	</div>
	
<%
        }
    }
%>

	<div class="card-links">
		<a href="pagination.cdac?move=prev ">Previous</a> <a
			href="pagination.cdac?move=next">Next</a>
	</div>

</body>
</html>