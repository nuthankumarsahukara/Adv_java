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
		Name : <input type="text" name="name" /><br/><br/>
		Phone Number : <input type="tel" pattern="[0-9]{10}" name="phone" /><br/><br/>
		Email :<input type="email" name="email_id" /><br/><br/>
		Password :<input type="password" name="password" /><br/><br/>		
		<input type="submit" value="Register"/>
	</form>
</body>
</html>