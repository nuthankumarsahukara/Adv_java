<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Base64"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Employee</title>
</head>
<body>
	<%
	    String user = (String) session.getAttribute("username");
	    if (user == null) {
	        response.sendRedirect("login");
	    }
	%>
	<p>Welcome, <%= user %>!</p>
	<button onclick="window.location='/index'">Add Employee</button>
	<table border=1 cellpadding=10>
		<tr>
			<th>Emp_ID</th>
			<th>Emp_Name</th>
			<th>Emp_Gender</th>
			<th>Emp_Email</th>
			<th>Emp_Dept</th>
			<th>Emp_Sal</th>
			<th>Emp_Phone</th>
			<th>Emp_Photo</th>
			<th colspan=2>Action</th>
		</tr>
		<c:forEach var="a" items="${data}">
		<tr>
			<td>${a.emp_id}</td>
			<td>${a.emp_name}</td>
			<td>${a.emp_gender}</td>
			<td>${a.emp_email}</td>
			<td>${a.emp_dept}</td>
			<td>${a.emp_sal}</td>
			<td>${a.emp_phone}</td>
			<td><img src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(a.emp_photo)}" width="100"/></td>
			<td><a href="/edit/${a.emp_id}">Edit</a> 
			<a href="/delete/${a.emp_id}">Delete</a></td>
		</tr>
	</c:forEach>	
	</table>
</body>
</html>