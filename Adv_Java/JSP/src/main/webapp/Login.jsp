<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Login</title>
</head>
<body>
	<%
	 if ("POST".equalsIgnoreCase(request.getMethod())) {
		 try{
		 String email=request.getParameter("email");
		 String password=request.getParameter("password");
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 String url="jdbc:oracle:thin:@localhost:1521/xe";
		 String username="system";
		 String pwd="nuthan";
		 Connection con=DriverManager.getConnection(url,username,pwd);
		 String query="select * from register where email= ? and password = ?";
		 PreparedStatement psmt=con.prepareStatement(query);
		 psmt.setString(1, email);
		 psmt.setString(2,password);
		 ResultSet rs=psmt.executeQuery();
		 if (rs.next()) {
         	session.setAttribute("loggedInUser",  rs.getString("name"));
             out.println("<h2>Login successful!</h2>");
             out.println("<meta http-equiv='refresh' content='3;URL=Table.jsp'>");
             out.println("<p>You will be redirected to your dashboard shortly.</p>");
         } else {
             out.println("<h2>Login failed! Invalid username or password.</h2>");
             out.println("<a href='Login.jsp'>Try again</a>");
         }
		 	rs.close();
		 	psmt.close();
		 	con.close();
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 
	 }else{
	%>
	<form action="Login.jsp" method="post">
		Email: <input type="email" name="email" /> <br/><br/>
		Password :<input type="password" name="password" /><br/><br/>
		<input type="submit" />
	</form>
	<%  } %>
</body>
</html>