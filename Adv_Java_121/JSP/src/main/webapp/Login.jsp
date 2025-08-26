<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<%
	if("POST".equalsIgnoreCase(request.getMethod())){
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="nuthan";
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection(url, username, password);
			String query="select * from java121jr where (email = ? or TO_CHAR(phone)= ?) and password=?";
			PreparedStatement ps=c.prepareStatement(query);
			ps.setString(1, uname);
			ps.setString(2, uname);
			ps.setString(3, pwd);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				session.setAttribute("loggedInUser",  rs.getString("name"));
				out.println("<h1>Login Successfully....</h1>");
				%>
					<script>
						setTimeout(() => {
							window.location="List.jsp"
						}, 2000);
					</script>
				<% 
			}else{
				out.println("<h1>User not found....</h1>");
				%>
					<script>
						setTimeout(() => {
							window.location="Login.jsp"
						}, 2000);
					</script>
				<%
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}else{
%>
<form action="Login.jsp" method="post">
	Username :<input type="text" name="uname" placeholder="Enter the Email or Mobile Number" size=30/><br/><br/>	
	Password :<input type="password" name="pwd" size=30/><br/><br/>
	<input type="submit"/>
</form>
<% } %>
</body>
</html>