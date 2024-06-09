<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Demo</title>
<style>
        .center {
            text-align: center;
        }
</style>
</head>
<body>

<div class="center">
	<a href="sum.jsp">Add</a> 
	<br><br>
	<a href="table.jsp"> Show Table</a>
	<br><br>
	<a href="login.jsp">login</a>
</div>

	<h1>This is JSP Demo</h1>
	<h2>Addition using tags</h2>
	<%!int a = 5, b = 4, sum = 0;%>
	<%
	sum = a + b;
	if (true) {
		System.out.println("sum is : " + sum);
	}
	%>

	<h3>
		Sum is
		<%=sum%></h3>

	<h2>Age</h2>
	<%
	int age = 24;
	if (age >= 18) {
	%>
	<h1>Eligible</h1>
	<%
	} else {
	%>
	<h2>Not Eligible</h2>
	<%
	}

	for (int i = 0; i < 10; i++) {
	%>
	<p><%=i%></p>
	<%
	}
	%>
	

</body>
</html>