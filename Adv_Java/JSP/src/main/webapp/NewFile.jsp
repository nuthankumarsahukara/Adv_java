<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to JSP Page From HTML Code</h1>
<%out.print("Welcome to JSP Page from Java Code"); %>
<%out.print(10*5); %>
<%="Welcome to Expression Tag"%>
<%! int a=50; %>
<%="The value of a is "+a %>
<%! int add(int a,int b){
		return a+b; 
	}
	%>
<%="The sum of 10,20  is "+add(10,20) %>
</body>
</html>