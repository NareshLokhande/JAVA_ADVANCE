<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL demo</title>
</head>
<body>
  
  <c:set var="num" value="${50+10}"></c:set>
  <c:set var="age" value="24"></c:set>
  <c:set var="id" value="2"></c:set>

		<h1> Num is ${ num }</h1>
		<c:if test="${age >= 18}">
			<h4>User is eligible</h4>
		</c:if>
		
		<c:choose>
			<c:when test="${id==1}">
				<h5>Aman</h5>
			</c:when>
			<c:when test="${id==2}">
				<h5>Naresh</h5>
			</c:when>
			<c:when test="${id==3}">
				<h5>Sid</h5>
			</c:when>
			<c:otherwise>
				It does not exist
			</c:otherwise>
		</c:choose>


		<c:forEach var="i" begin="1" end="5">
			<h5>Value is ${i}</h5>
		</c:forEach>
		
		<table border="1" cellpadding="10" cellspacing="0">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Phone</th>
			<th>Marks</th>
			<th>City</th>
			<th>Gender</th>
		</tr>
		<c:forEach items="${studentsList}" var="s">
			<tr>
				<td>${s.getId()}</td>
				<td>${s.getName()}</td>
				<td>${s.getPhone()}</td>
				<td>${s.getMarks()}</td>
				<td>${s.getCity()}</td>
				<td>${s.getGender()}</td>
			</tr>
		</c:forEach>
		</table>
		
</body>
</html>