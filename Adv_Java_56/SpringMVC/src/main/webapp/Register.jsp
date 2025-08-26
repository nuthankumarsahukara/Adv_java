<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Register Page</h1>
	<form action="register" method="post">
		Name :<input type="text" name="name" /><br/><br/>
		Email:<input type="email" name="email" /><br/><br/>
		Password :<input type="password" name="password" /><br/><br/>
		<input type="submit" value="Register"/>
	</form>
	<p>Do you Have Account ? <a href="/login">Login</a></p>
</body>
</html>