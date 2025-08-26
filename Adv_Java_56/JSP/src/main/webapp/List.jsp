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
<title>List Example</title>
<style>
.box{
	display:flex;
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
		<h1>Employee Details</h1>
		<button onclick="window.location='Dashboard.jsp'">Add Employee</button>
	</div>
	<table align="center" border=1 rules="all">
		<tr>
			<th>Employee ID</th>
			<th>Employee Name</th>
			<th>Employee DOJ</th>
			<th>Employee Salary</th>
			<th>Employee Department</th>
			<th>Employee Gender</th>
			<th>Employee Address</th>
			<th>Employee Education</th>
			<th colspan=2>Action</th>
		</tr>
		<%
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
        	String username = "system";
        	String password = "nuthan";
			
        	try{
        		Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection(url, username, password);
                String sql = "select * from java56e";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs=ps.executeQuery();
                while(rs.next()){        	
		%>
			<tr align="center">
				<td><%= rs.getInt(1) %></td>
				<td><%= rs.getString(2) %></td>
				<td><%= rs.getDate(3) %></td>
				<td><%= rs.getLong(4) %></td>
				<td><%= rs.getString(5) %></td>
				<td><%= rs.getString(6) %></td>
				<td><%= rs.getString(7) %></td>
				<td><%= rs.getString(8) %></td>
				<td><a href="Update.jsp?emp_id=<%= rs.getInt(1) %>">Update</a></td>
				<td><a href="Delete.jsp?emp_id=<%= rs.getInt(1) %>">Delete</a></td>
			</tr>
		<% } 
        }catch(Exception e){
        	e.printStackTrace();        	
        }
		%>	
		
	</table>
</body>
</html>