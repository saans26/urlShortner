<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>URL Shortner</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div align="center">
	<h1>URL Shortner</h1>
	<form action="<%= request.getContextPath() %>/addUrl" method="post">
		<label>URL</label>
		<input type="text" name ="fullUrl"><br>
		<input type="submit" class="btn btn-success"><br>
	</form>
	<a href="${urlData.getShortUrl()} ">${urlData.getShortUrl()} </a>
</div>
</body>
</html>