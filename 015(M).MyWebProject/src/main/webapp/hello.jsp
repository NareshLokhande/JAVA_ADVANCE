<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello</h1>
	<% 
	LocalDate date = LocalDate.now();
	%>
	
	<h2>Today's Data is <%=date %></h2>
	
	<% String str = "Hello JSP"; %>
</body>
</html>	