<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

	<form action="LoginServlet">
		<input type="text" placeholder="Username" name="username">
		<br><br>
		<input type="password" placeholder="Password" name="password">
		<br><br>
		<input type="submit" value="Login">
		<br><br>
	</form>

<%
	if(request.getAttribute("loginError") != null){
		%>
		<h4><%=request.getAttribute("loginError") %></h4>
		<%
	}
	else{
		
	}
%>
</body>
</html>