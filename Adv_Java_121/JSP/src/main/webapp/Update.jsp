<%@page import="java.util.Collections"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
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
		if("POST".equalsIgnoreCase(request.getMethod())){
			String std_id=request.getParameter("std_id");
			String std_name=request.getParameter("std_name");
			String std_fname=request.getParameter("std_fname");
			String std_mname=request.getParameter("std_mname");
			String std_dob=request.getParameter("std_dob");
			String std_gender=request.getParameter("std_gender");
			String[] selectedSports = request.getParameterValues("sports");
			String sports = (selectedSports != null) ? String.join(",", selectedSports) : "None";
			String std_phone=request.getParameter("std_phone");
			String std_class=request.getParameter("std_class");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String username="system";
			String password="nuthan";
			
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection c=DriverManager.getConnection(url, username, password);
				String query="update java121s set std_name=? ,std_fname=?,std_mname=?,std_dob=?,std_gender=?,std_sports=?,std_phone=?,std_class=? where std_id=?";
				PreparedStatement ps=c.prepareStatement(query);
				ps.setString(9, std_id);
				ps.setString(1, std_name);
				ps.setString(2, std_fname);
				ps.setString(3, std_mname);
				ps.setDate(4, java.sql.Date.valueOf(std_dob));
				ps.setString(5, std_gender);
				ps.setString(6, sports);
				ps.setString(7,std_phone);
				ps.setString(8,std_class);
				
				int rows=ps.executeUpdate();
				if(rows>0){
					out.println("<h1>Updated Student Data Successfully...</h1>");
			%>
				<script>
					setTimeout(() => {
						window.location="List.jsp"
					}, 2000);
				</script>	
			<%		
				}else{
					out.println("<h1>Student Data not added Successfully...</h1>");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
	%>
		<h1>Update Student Details</h1>
		<form action="Update.jsp" method="post">
			<%
			try{
				String std_id=request.getParameter("std_id");
				String url="jdbc:oracle:thin:@localhost:1521:xe";
				String username="system";
				String password="nuthan";
				Class.forName("oracle.jdbc.driver.OracleDriver");				
				Connection c=DriverManager.getConnection(url, username, password);
				String query="select * from java121s where std_id=?";
				PreparedStatement ps=c.prepareStatement(query);
				ps.setString(1, std_id);
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
			%>
			Student Id :<input type="tel" pattern='[0-9]{3,5}' name="std_id" value="<%= rs.getInt(1) %>" /> <br/><br/>
			Student Name :<input type="text" name="std_name" value="<%= rs.getString(2) %>"/> <br/><br/>
			Student Father Name :<input type="text" name="std_fname" value="<%= rs.getString(3) %>"/> <br/><br/>
			Student Mother Name :<input type="text" name="std_mname" value="<%= rs.getString(4) %>" /> <br/><br/>
			Student DOB :<input type="date" name="std_dob" value="<%= rs.getDate(5) %>"/> <br/><br/>
			<% String gender=rs.getString(6); %>
			Student Gender :
			<input type="radio" name="std_gender" value="male" <%= (gender.equalsIgnoreCase("Male") ? "checked" : "") %>/> Male
			<input type="radio" name="std_gender" value="female" <%= (gender.equalsIgnoreCase("Female") ? "checked" : "")%> />Female<br/><br/>
			<% String sports=rs.getString(7);
			List<String> selSports = (sports != null)
				    ? Arrays.asList(sports.split(","))
				    : Collections.emptyList();
			%>
			Student Sports :
			<input type="checkbox" name="sports" value="Cricket" <%= selSports.contains("Cricket") ? "checked" : "" %> /> Cricket
			<input type="checkbox" name="sports" value="Football" <%= selSports.contains("Football") ? "checked" : "" %> /> Football
			<input type="checkbox" name="sports" value="Hockey" <%= selSports.contains("Hockey") ? "checked" : "" %> /> Hockey <br/><br/>
			Student Phone :<input type="tel" pattern='[0-9]{10}' name="std_phone" value="<%= rs.getLong(8) %>"/> <br/><br/>
			
			<% String className=rs.getString(9); %>
			Student Class :
			<select name="std_class">
				<option <%= "LKG".equalsIgnoreCase(className) ? " selected" : "" %>>LKG</option>
				<option <%= "UKG".equalsIgnoreCase(className) ? " selected" : "" %>>UKG</option>
				<option <%= "1st class".equalsIgnoreCase(className) ? " selected" : "" %>>1st Class</option>
				<option <%= "2nd class".equalsIgnoreCase(className) ? " selected" : "" %>>2nd Class</option>
				<option <%= "3rd class".equalsIgnoreCase(className) ? " selected" : "" %>>3rd Class</option>
				<option <%= "4th class".equalsIgnoreCase(className) ? " selected" : "" %>>4th Class</option>
				<option <%= "5th class".equalsIgnoreCase(className) ? " selected" : "" %>>5th Class</option>
				<option <%= "6th class".equalsIgnoreCase(className) ? " selected" : "" %>>6th Class</option>
				<option <%= "7th class".equalsIgnoreCase(className) ? " selected" : "" %>>7th Class</option>
				<option <%= "8th class".equalsIgnoreCase(className) ? " selected" : "" %>>8th Class</option>
				<option <%= "9th class".equalsIgnoreCase(className) ? " selected" : "" %>>9th Class</option>
				<option <%= "10th class".equalsIgnoreCase(className) ? " selected" : "" %>>10th Class</option>
			</select><br/><br/>
			<input type="submit" />
			<% }
			}catch(Exception e){
				e.printStackTrace();
				
			}	
			%>
		</form>
	<% } %>
</body>
</html>