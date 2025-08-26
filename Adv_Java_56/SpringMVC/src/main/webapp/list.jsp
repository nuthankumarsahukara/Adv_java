<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Base64"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student List</title>
<style>
	.flexbox{
		display:flex;
		justify-content: space-around;
		align-items: center;
	}
</style>
</head>
<body>
	<div class="flexbox">
		<h1>Student Details</h1>
		<button onclick="window.location='/index'">Add Student</button>
		<button onclick="window.location='/logout'">Logout</button>
	</div>
	<table border=2 align="center" rules="all">
		<tr>
			<td>Student ID</td>
			<td>Student Name</td>
			<td>Student DOB</td>
			<td>Student Gender</td>
			<td>Student Course</td>
			<td>Student Phone Number</td>
			<td>Student Email ID</td>
			<td>Student Photo</td>
			<td colspan="2">Action</td>
		</tr>
		<c:forEach var="a" items="${data}"> 
			<tr align="center">
				<td>${a.std_id}</td>
				<td>${a.std_name}</td>
				<td>${a.std_date}</td>
				<td>${a.std_gender}</td>
				<td>${a.std_course}</td>
				<td>${a.std_phone}</td>
				<td>${a.std_email}</td>
				<td><img src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(a.std_photo)}" width="100"/></td>
				<td><a href="edit/${a.std_id}">Update</a></td>
				<td><a href="delete/${a.std_id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>