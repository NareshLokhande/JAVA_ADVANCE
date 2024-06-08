<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Table</title>
<style>
        .center {
            text-align: center;
        }
        
        table {
            margin: 0 auto;
        }
</style>
</head>
<body>
<div class="center">

<%
	String s1[] = {"101","Naresh","9822164"};
	String s2[] = {"102","Pushpak","547782"};
	String s3[] = {"103","Modi","875542"};
	
	String students[][] = {s1,s2,s3};
%>
	<h2>Students Table</h2>
	<table border="1" cellpadding='10' cellspacing='0' class="table">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Phone</th>
		</tr>
	
	
	<%
	for(int i=0; i<students.length; i++){
		%>
			<tr>
				<td><%=students[i][0] %></td>
				<td><%=students[i][1] %></td>
				<td><%=students[i][2] %></td>
			</tr>
		<%
	}	
	%>
	</table>
	
	<br><br>
	<a href="index.jsp">Home</a>
	
	</div>
</body>
</html>