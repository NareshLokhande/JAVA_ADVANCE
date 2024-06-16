<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.productmvc.model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<div class="container mt-5">
		<div class="alert alert-primary text-center" role="alert">
			List of all the Products
		</div>
		</div>
		<div class="container mt-5">
			<%
			List<Product> products = (ArrayList<Product>) request.getAttribute("list");
			%>
			<table class="table table-hover">
				<thead>
					<tr">
						<th scope="col">Id</th>
						<th scope="col">Name</th>
						<th scope="col">Price (Rs)</th>
						<th scope="col">Quantity</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody>
					<%
					Iterator<Product> itr = products.iterator();
					while (itr.hasNext()) {
						Product p = itr.next();
					%>
					<tr>
						<td><%=p.getId()%></td>
						<td><%=p.getName()%></td>
						<td><%=p.getPrice()%></td>
						<td><%=p.getQty()%></td>
						<td><a href="remove-product/<%=p.getId()%>"
							class="btn btn-danger">Delete</a></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
			<div class="mt-3 text-center">
				<a href="index.jsp" class="btn btn-dark">Go to Add page</a>
			</div>
		</div>
</body>
</html>