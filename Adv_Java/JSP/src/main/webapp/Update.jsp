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
</head>
<body>
<%
	String loggedInUser = (String) session.getAttribute("loggedInUser");
	if (loggedInUser == null) {
	    out.println("<h2>You need to log in to access this page.</h2>");
	    out.println("<meta http-equiv='refresh' content='1; URL=Login.jsp'>");
	    return;
	}
%>
<%
	String stdid=request.getParameter("stdid");
	String jdbcUrl = "jdbc:oracle:thin:@localhost:1521/xe";
	String jdbcUser = "system";
	String jdbcPassword = "nuthan";
	String stdname =null,stdcourse=null,stdbranch=null;
	if ("POST".equalsIgnoreCase(request.getMethod())) {
        stdname = request.getParameter("stdname");
        stdcourse = request.getParameter("stdcourse");
        stdbranch = request.getParameter("stdbranch");
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection(jdbcUrl,jdbcUser,jdbcPassword);
		String query="update std set stdname=?, stdcourse=?, stdbranch=? WHERE stdid=?";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, stdname);
		ps.setString(2, stdcourse);
		ps.setString(3, stdbranch);
		ps.setString(4, stdid);
		
		int rows=ps.executeUpdate();
		if(rows>0){
			out.println("<h3>Data Updated Successfully...</h3>");
			out.println("<meta http-equiv='refresh' content='1;URL=Table.jsp'>");
            out.println("<p>You will be redirected to your Table shortly.</p>");
		}
	}catch(Exception e){
		e.printStackTrace();
		out.println("<h2>Error updating student!</h2>");
	}
	}else{
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection(jdbcUrl,jdbcUser,jdbcPassword);
		String query="select * from std where stdid=?";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, stdid);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			stdname =rs.getString("stdname");
			stdcourse =rs.getString("stdcourse");
			stdbranch =rs.getString("stdbranch");
		}
		}catch(Exception e){
			e.printStackTrace();
			out.println("<h2>Error fetching student!</h2>");
		}
	}
%>
<% if (!"POST".equalsIgnoreCase(request.getMethod())) { %>
    <h2>Edit Student</h2>
    <form action="Update.jsp?stdid=<%= stdid %>" method="post">
        <label>Student Name:</label><br>
        <input type="text" name="stdname" value="<%= stdname %>" required><br><br>

        <label>Student Course:</label><br>
        <input type="text" name="stdcourse" value="<%= stdcourse %>" required><br><br>
        
        <label>Student Address:</label><br>
        <input type="text" name="stdbranch" value="<%= stdbranch %>" required><br><br>

        <input type="submit" value="Update">
    </form>
<% } %>
</body>
</html>