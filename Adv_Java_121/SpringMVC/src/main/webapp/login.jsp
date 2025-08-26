<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="post">
		Email :<input type="email" name="email_id" /><br/><br/>
		Password :<input type="password" name="password" /><br/><br/>		
		<input type="submit" value="Login"/>
	</form>
	<p>For <a href="/register">Register</a> ?</p>
</body>
</html>