<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<style>
	.box{
		display: flex;
		justify-content: space-around;
		align-items: center;
	}
</style>
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
	<%
		if("POST".equalsIgnoreCase(request.getMethod())){
			String std_id=request.getParameter("std_id");
			String std_name=request.getParameter("std_name");
			String std_fname=request.getParameter("std_fname");
			String std_mname=request.getParameter("std_mname");
			String std_dob=request.getParameter("std_dob");
			String std_gender=request.getParameter("std_gender");
			String[] selectedSports = request.getParameterValues("sports");
			String std_phone=request.getParameter("std_phone");
			String std_class=request.getParameter("std_class");
			
			String sports = "None";
	        if (selectedSports != null) {
	            sports = String.join(",", selectedSports);
	        }
	        
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String username="system";
			String password="nuthan";
			
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection c=DriverManager.getConnection(url, username, password);
				String query="insert into java121s values(?,?,?,?,?,?,?,?,?)";
				PreparedStatement ps=c.prepareStatement(query);
				ps.setString(1, std_id);
				ps.setString(2, std_name);
				ps.setString(3, std_fname);
				ps.setString(4, std_mname);
				ps.setDate(5, java.sql.Date.valueOf(std_dob));
				ps.setString(6, std_gender);
				ps.setString(7, sports);
				ps.setString(8,std_phone);
				ps.setString(9,std_class);
				
				int rows=ps.executeUpdate();
				if(rows>0){
					out.println("<h1>Added Student Data Successfully...</h1>");
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
		<div class="box">
			<h1>Student Details</h1>
			<button onclick="window.location='List.jsp'">All Students Details</button>
		</div>
		<div class="formDetials">
		<form action="Dashboard.jsp" method="post">
			Student Id :<input type="tel" pattern='[0-9]{3,5}' name="std_id" /> <br/><br/>
			Student Name :<input type="text" name="std_name" /> <br/><br/>
			Student Father Name :<input type="text" name="std_fname" /> <br/><br/>
			Student Mother Name :<input type="text" name="std_mname" /> <br/><br/>
			Student DOB :<input type="date" name="std_dob" /> <br/><br/>
			Student Gender :
			<input type="radio" name="std_gender" value="male"/>Male
			<input type="radio" name="std_gender" value="female" />Female<br/><br/>
			Student Sports :
			<input type="checkbox" name="sports" value="Cricket"/> Cricket
			<input type="checkbox" name="sports" value="FootBall" />Football
			<input type="checkbox" name="sports" value="Hockey" />Hockey<br/><br/>
			Student Phone :<input type="tel" pattern='[0-9]{10}' name="std_phone" /> <br/><br/>
			Student Class :
			<select name="std_class">
				<option>LKG</option>
				<option>UKG</option>
				<option>1st Class</option>
				<option>2rd Class</option>
				<option>3nd Class</option>
				<option>4th Class</option>
				<option>5th Class</option>
				<option>6th Class</option>
				<option>7th Class</option>
				<option>8th Class</option>
				<option>9th Class</option>
				<option>10th Class</option>
			</select><br/><br/>
			<input type="submit" />
		</form>
		</div>
	<% } %>
</body>
</html>