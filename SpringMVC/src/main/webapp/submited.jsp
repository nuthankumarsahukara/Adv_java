<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="text-align: center">
	<h1>Data List</h1>
	<table border="1px" align="center" rules="all" width="75%">
	<tr>
		<th>Name</th>
		<th>Email</th>
		<th>Phone Number</th>
		<th>Action</th>
	</tr>
	
	<c:forEach var="a" items="${data}">
		<tr>
			<td>${a.name}</td>
			<td>${a.email}</td>
			<td>${a.phone}</td>
			<td><a href="/edit/${a.id}">Edit</a> 
			| <a href="/delete/${a.id}">Delete</a></td>
		</tr>
	</c:forEach>	
	</table>
	<a href="/">Add Data</a>
</body>
</html>