<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body style="text-align: center">
	<h1>Welcome to Home Page</h1>
	<form action="submited" method="post">
		<input type="text" name="name" placeholder="Name"/><br/><br/>
		<input type="email" name="email" placeholder="Email"/><br/><br/>
		<input type="tel" pattern="[0-9]{10}" name="phone" placeholder="Phone Number"/><br/><br/>
		<input type="submit"/>
	</form>
</body>
</html>