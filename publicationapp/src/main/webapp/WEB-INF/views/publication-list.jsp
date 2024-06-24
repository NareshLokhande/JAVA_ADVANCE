<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.publicationapp.model.Publication"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Publication List Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>

	<div class="container mt-5">
		<div class="alert alert-primary text-center" role="alert">List
			of All Publication</div>
		<div class="container mt-5">
			<%
			List<Publication> publications = (ArrayList<Publication>) request.getAttribute("list");
			%>
			
			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Title</th>
						<th scope="col">Type</th>
						<th scope="col">Content</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody>
					<%
						Iterator<Publication> itr = publications.iterator();
						while(itr.hasNext()){
							Publication p = itr.next();
					%>
					
					<tr>
						<td><%=p.getId() %></td>
						<td><%=p.getTitle() %></td>
						<td><%=p.getType() %></td>
						<td><%=p.getContent() %></td>
						<td>
						<a href="update-publication/<%=p.getId() %>" class="btn btn-danger" >Edit</a>
						<a href="remove-publication/<%=p.getId() %>" class="btn btn-danger" >Delete</a></td>		
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
			<div class="mt-3 text-center">
				<a href="index.jsp" class="btn btn-dark">Go to Add</a>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>