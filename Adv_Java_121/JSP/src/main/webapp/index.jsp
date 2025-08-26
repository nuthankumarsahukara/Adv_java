<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to JSP from HTML tag</h1>
	<!--Script let Tag --> 
	<% out.println("Welcome to JSP from jsp tag"); %>	
	<br/>
	<% out.println(10+15); %>
	<br/><br/>
	
	<!--Expression Tag --> 
	<%= "Welcome to JSP from jsp tag" %>	
	<br/><br/>
	<%= 10*50 %>
	<br/><br/>
	<!--Declaration Tag --> 
	<%! int a=10; %>
	<%= "The value of a is "+a %><br/>
	<%! int cube(int n){
		return n*n*n;
	}
		%>
	<%= "The cube of 4 is "+cube(4) %><br/>
	<%= "The cube of 5 is "+cube(5) %><br/>
	<%= "The cube of 6 is "+cube(6) %><br/>
</body>
</html>