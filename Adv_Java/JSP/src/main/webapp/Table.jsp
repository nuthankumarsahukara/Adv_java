<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Table</title>
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
	<div style="display: flex; justify-content: space-between; align-items: center; margin:0px 100px">
		<h1 >Student Details</h1>
		<button onclick="location='Insert.jsp'">Add Student</button>
	</div>
	<%
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system","nuthan");
			String Query="select * from std";
			PreparedStatement ps=con.prepareStatement(Query);
			ResultSet rs=ps.executeQuery();			
			out.println("<table border='5' rules='all' align='center' width='75%'>");
			out.println("<tr>");
				out.println("<th> Student RollNo </th>");
				out.println("<th> Student Name </th>");
				out.println("<th> Student Course </th>");
				out.println("<th> Student Branch </th>");
				out.println("<th> Action </th>");
			out.println("</tr>");
			while(rs.next()){					
					out.println("<tr align='center'>");
					out.println("<td>"+ rs.getInt("stdid") +"</td>");
					out.println("<td>"+ rs.getString("stdname") +"</td>");
					out.println("<td>"+ rs.getString("stdcourse") +"</td>");
					out.println("<td>"+ rs.getString("stdbranch") +"</td>");
					out.println("<td><a href='Update.jsp?stdid= "+ rs.getInt("stdid")+"'>Update</a> | <a href='Delete.jsp?stdid= "+ rs.getInt("stdid")+"'>Delete</a></td>");
				out.println("</tr>");						
			}
			out.println("</table>");
			ps.close();
			rs.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	%>
</body>
</html>