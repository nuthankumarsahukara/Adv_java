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
	try{
		String stdid=request.getParameter("stdid");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system","nuthan");
		String query="delete from std where stdid =?";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, stdid);
		int row=ps.executeUpdate();
		if(row>0){
			out.println("<h3>Delete Data Successfully...</h3>");
			out.println("<meta http-equiv='refresh' content='1;URL=Table.jsp'>");
            out.println("<p>You will be redirected to your Table shortly.</p>");
		}
	}catch(Exception e){
		e.printStackTrace();
		out.println("<h3>Error!!!! Unable to Delete the record</h3>");
	}

%>
</body>
</html>