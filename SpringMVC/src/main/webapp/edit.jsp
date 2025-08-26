<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Page</title>
</head>
<body>
	<h1>Edit Page</h1>
	<form action="/update" method="post">
		<input type="hidden" name="id" value="${data.id}"/>
		<input type="text" name="name" value="${data.name}" placeholder="Name"/><br/><br/>
		<input type="email" name="email" value="${data.email}" placeholder="Email"/><br/><br/>
		<input type="tel" pattern="[0-9]{10}" value="${data.phone}" name="phone" placeholder="Phone Number"/><br/><br/>
		<input type="submit" value="Update"/>
	</form>
	<a href="/submited">List</a>
</body>
</html>