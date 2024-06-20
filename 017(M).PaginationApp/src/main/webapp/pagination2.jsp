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

	<%!
	int offset = 0;
	%>

	<%
	//Passing parameter in url
	String move = request.getParameter("move");
	//Add the boundry condition for next and prev
	if (move != null) {
		if (move.equals("next"))
			offset += 5;
		else if (move.equals("prev"))
			offset -= 5;
	}

	//JDBC code
	Connection conn = null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdac", "root", "cdac");

		String qry = "SELECT * FROM tbl_product limit 5 offset ?";
		PreparedStatement pstmt = conn.prepareStatement(qry);
		pstmt.setInt(1, offset);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			double price = rs.getDouble(3);
			int quantity = rs.getInt(4);
	%>
	<div class="card">
		<div class="container">
			<h4>
				<b><%=id%></b>
			</h4>
			<p><%=name%></p>
			<p><%=price%></p>
			<p><%=quantity%></p>
		</div>
	</div>
	<%
	}
	} catch (Exception e) {
	e.printStackTrace();
	}
	%>

	<div class="card-links">
		<a href="pagination2.jsp?move=prev ">Previous</a> <a
			href="pagination2.jsp?move=next">Next</a>
	</div>

</body>
</html>