<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page  import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%  
	 if ("POST".equalsIgnoreCase(request.getMethod())) {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String ph=request.getParameter("phonenumber");
		String pwd=request.getParameter("password");

	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521/xe";
		String username="system";
		String password="nuthan";
		Connection con=DriverManager.getConnection(url,username,password);
		String query="insert into register values(?,?,?,?)";
		PreparedStatement psmt=con.prepareStatement(query);
		psmt.setString(1, name);
		psmt.setString(2, email);
		psmt.setString(3, pwd);
		psmt.setString(4, ph);
		int row=psmt.executeUpdate();
		if(row > 0){
			out.println("<h1>Thank You Register Successfully....</h1>");
			out.println("<meta http-equiv='refresh' content='3; url=Login.jsp'>");
			out.println("<h4>Page Redirect to login page....</h4>");			
		}
		psmt.close();
		con.close();
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}catch(SQLException e){
		e.printStackTrace();
	}
	}else{
%>
	<form action="Register.jsp" method="post">
		Name : <input type="text" name="name" /> <br/><br/>
		Email: <input type="email" name="email" /> <br/><br/>
		Phone Number :<input type="tel" pattern="[0-9]{10}" name="phonenumber" /> <br/><br/>
		Password :<input type="password" name="password" /><br/><br/>
		<input type="submit" />
	</form>
<% } %>
</body>
</html>