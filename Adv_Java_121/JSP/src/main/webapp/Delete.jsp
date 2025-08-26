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
</head>
<body>
	<% 
		String std_id=request.getParameter("std_id");
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="nuthan";
		
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection c=DriverManager.getConnection(url, username, password);
		String query="Delete from java121s where std_id=?";
		PreparedStatement ps=c.prepareStatement(query);
		ps.setString(1, std_id);
		int rows=ps.executeUpdate();
		if(rows>0){
			%>
				<script>
					setTimeout(() => {
						window.location="List.jsp"
					}, 0);
				</script>
			<%
			
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	%>
</body>
</html>