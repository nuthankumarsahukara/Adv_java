<%@page import="java.sql.*"%>
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
	String loggedInUser = (String) session.getAttribute("loggedInUser");
	if (loggedInUser == null) {
	    out.println("<h2>You need to log in to access this page.</h2>");
	    out.println("<meta http-equiv='refresh' content='2; URL=Login.jsp'>");
	    return;
	}
	%>
	<% if ("POST".equalsIgnoreCase(request.getMethod())) { 
		try{
			String stdid=request.getParameter("stdid"); 
			String stdname=request.getParameter("stdname"); 
			String stdcourse=request.getParameter("stdcourse"); 
			String stdbranch=request.getParameter("stdbranch");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system","nuthan");
			String Query="insert into std values (?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(Query);
			ps.setString(1, stdid);
			ps.setString(2, stdname);
			ps.setString(3, stdcourse);
			ps.setString(4, stdbranch);
			
			int rows=ps.executeUpdate();
			
			if(rows>0){
				out.println("<h3>Insert Data Successfully...</h3>");
				out.println("<meta http-equiv='refresh' content='2;URL=Table.jsp'>");
	            out.println("<p>You will be redirected to your Table shortly.</p>");				
			}
			ps.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}else{
	%>
	<form action="Insert.jsp" method="post">
		Student RollNo :<input type="tel" pattern="[0-9]{5}" name="stdid" required/> <br/><br/>
		Student Name :<input type="text" name="stdname" required/><br/><br/>
		Student Course :<input type="text" name="stdcourse" required/><br/><br/>
		Student Branch :<input type="text" name="stdbranch" required /><br/><br/>
		<input type="submit"/>	
	</form>
	<% } %>
</body>
</html>