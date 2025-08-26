
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
	if("POST".equalsIgnoreCase(request.getMethod())){
	String name=request.getParameter("name"); 
	String email=request.getParameter("email"); 
	String gender=request.getParameter("gender");
	String phone=request.getParameter("phone");
	String pwd=request.getParameter("pwd");
	
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String username="system";
	String password="nuthan";
	
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection c=DriverManager.getConnection(url, username, password);
		String query="insert into java56jr values(?,?,?,?,?)";
		PreparedStatement ps=c.prepareStatement(query);
		ps.setString(1, name);
		ps.setString(2, email);
		ps.setString(3,gender);
		ps.setString(4, phone);
		ps.setString(5,pwd);
		
		int row=ps.executeUpdate();
		if(row>0){
				out.println("<h1>Data submitted successfully....</h1>");
				out.println("<script>");
				out.println("setTimeout(()=>{window.location='Login.jsp'} ,3000)}");
				out.println("<script>");
		}
		ps.close();
		c.close();
	}catch(Exception e){
		e.printStackTrace();
	}
	}else{
%>
	<h1>Register Page</h1>
	<form action="Register.jsp" method="post">
		Name : <input type="text" name="name" /><br/><br/>
		Email : <input type="email" name="email" /><br/><br/>
		Gender :<input type="radio" name="gender" value="male"/>Male
		<input type="radio" name="gender" value="female"/>Female <br/><br/>
		Phone Number :<input type="tel" pattern="[0-9]{10}" name="phone"/><br/><br/>
		Password :<input type="password" name="pwd"/><br/><br/>
		<input type="submit"/>
	</form>	
	
<% } %>
</body>
</html>