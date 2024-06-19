<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Using JSP file</title>
</head>
<body>
<%
	int num1 = Integer.parseInt(request.getParameter("num1"));
	int num2 = Integer.parseInt(request.getParameter("num2"));
	int sum = num1+num2;
	String result = "Sum of "+num1+" and "+num2+" is "+sum;
%>
	
	<h3>The sum of <%=num1 %> and <%=num2 %> is <%=sum %></h3>
	<h3><%=result %></h3>
</body>
</html>