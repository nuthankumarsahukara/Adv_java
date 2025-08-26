<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Page</title>
</head>
<body>
	<h1>Welcome to JSP </h1>
	<!-- script let Tag -->
	<%out.println(5*6); %>
	<br/>	
	<%out.println(" Welcome to RCB"); %>
	<br/>	
	<%= "welcome to PBKS" %>
	<%! int data=50; %> 
	<br/><br/> 
	<%= "Value of the variable is:"+data %> 
	<br/><br/>
	<!-- Declaration Tag -->
	<%!   
		int cube(int n){  
		return n*n*n;  
		}  
		%> 
	<!-- Expression Tag --> 
	<%= "Cube of 3 is:"+cube(3) %> <br/>
	<%= "Cube of 6 is:"+cube(6) %> <br/>
	<%= "Cube of 8 is:"+cube(8) %> 
</body>
</html>