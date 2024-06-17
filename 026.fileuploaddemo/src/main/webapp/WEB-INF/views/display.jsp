<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Uploaded File</title>
	<style>
    	img {
        	max-width: 500px;  /* Set the maximum width */
        	height: auto;     /* Maintain the aspect ratio */
    	}
	</style>
</head>
<body>
<h1>Your Uploaded file</h1>
<%
	String filename =(String)request.getAttribute("image");
%>
	<img src="resources/image/<%=filename%>">
</body>
</html>