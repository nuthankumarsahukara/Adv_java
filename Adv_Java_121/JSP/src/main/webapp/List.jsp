<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.box{
		display: flex;
		justify-content: space-around;
		align-items: center;
	}
</style>
</head>
<body>
	<%
	String loggedInUser = (String) session.getAttribute("loggedInUser");
	if (loggedInUser == null) {
	    out.println("<h2>You need to log in to access this page.</h2>");
	    out.println("<meta http-equiv='refresh' content='2; URL=Login.jsp'>");
	    return;
	}
	%>
	<div class="box">
		<h1>Student List</h1>
		<button onclick="window.location='Dashboard.jsp'">Add Student</button>
	</div>
	<table align="center" rules="all" border=1>
		<tr>
			<th>Student ID</th>
			<th>Student Name</th>
			<th>Student Father Name</th>
			<th>Student Mother Name</th>
			<th>Student DOB</th>
			<th>Student Gender</th>
			<th>Student Sports</th>
			<th>Student Phone Number</th>
			<th>Student Class</th>
			<th colspan="2">Action</th>
		</tr>
		<% 
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="nuthan";
		
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection c=DriverManager.getConnection(url, username, password);
		String query="select * from java121s";
		PreparedStatement ps=c.prepareStatement(query);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){		
	%>
		<tr align="center">
			<td><%= rs.getInt(1) %></td>
			<td><%= rs.getString(2) %></td>
			<td><%= rs.getString(3) %></td>
			<td><%= rs.getString(4) %></td>
			<td><%= rs.getDate(5) %></td>
			<td><%= rs.getString(6) %></td>
			<td><%= rs.getString(7) %></td>
			<td><%= rs.getLong(8) %></td>
			<td><%= rs.getString(9) %></td>
			<td><a href="Update.jsp?std_id=<%= rs.getInt(1) %>">Update</a></td>
			<td><a href="Delete.jsp?std_id=<%= rs.getInt(1) %>">Delete</a></td>
		</tr>
		<% } 
		}catch(Exception e){
			e.printStackTrace();
		}		
		%>
	</table>
</body>
</html>