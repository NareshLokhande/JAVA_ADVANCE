<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Addition of Two Numbers</title>
<style>
        .center {
            text-align: center;
        }
</style>
</head>
<body>
<div class="center">
	<form action="">
		<h1>Addition of Two Numbers</h1>
		<input type="text" placeholder="First Value" name="n1">
		<br> <br> 
		<input type="text" placeholder="Second Value" name="n2"> 
		<br> <br>
		<input type="submit" value="Add" name="btn">

	<%
		if(request.getParameter("btn") != null){
			int a = Integer.parseInt(request.getParameter("n1"));
			int b = Integer.parseInt(request.getParameter("n2"));
			
			int c = a+b;
			%>
			<h3>Sum is <%=c %></h3>
			<%
		}
		else{
			//response.sendRedirect("sum.jsp");
		}
		
	%>
	
		</form>
		
		<br><br>
		<a href="index.jsp">Home</a>	
</div>
</body>
</html>