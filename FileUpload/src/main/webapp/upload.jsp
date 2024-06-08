<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="uploadServlet" method="post" enctype="multipart/form-data">
		<input type="file" name="file">
		<input type="submit" value="submit">
	</form>
	<% String content = (String) request.getAttribute("content"); %>

	<p><%= content %></p>

</body>
</html>