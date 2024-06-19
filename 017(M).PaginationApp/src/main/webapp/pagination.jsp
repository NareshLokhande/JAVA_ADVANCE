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
</head>
<body>
<%
	//JDBC code
	
	int offset = 0;

	Connection conn = null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdac", "root", "cdac");

		String qry = "SELECT * FROM tbl_product LIMIT 5 offset ?";
		PreparedStatement pstmt = conn.prepareStatement(qry);
		pstmt.setInt(1, offset);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
			if(rs.next()){
				int id = rs.getInt(1); 
				String name = rs.getString(2);
				double price = rs.getDouble(3);
				int quantity = rs.getInt(4);
%>
	<div>
		<%=id %>
		<%=name %>
		<%=price %>
		<%=quantity %>
	</div>
<%
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	%>
</body>
</html>