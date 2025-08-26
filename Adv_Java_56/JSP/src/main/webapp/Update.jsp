<%@page import="java.util.Collections"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
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

	<%
    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String emp_id =request.getParameter("emp_id");
        String emp_name = request.getParameter("emp_name");
        String emp_doj = request.getParameter("emp_doj");
        String emp_sal = request.getParameter("emp_sal");
        String emp_dept = request.getParameter("emp_dept");
        String emp_gender = request.getParameter("emp_gender");
        String emp_address = request.getParameter("emp_address");
        String[] education=request.getParameterValues("emp_education");
        String emp_education = (education != null) ? String.join(",", education) : "None";        		
		
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "system";
        String password = "nuthan";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(url, username, password);

            String sql = "update java56e set emp_name=?,emp_doj=?,emp_sal=?,emp_dept=?,emp_gender=?,emp_address=?,emp_education=? where emp_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(8, emp_id);
            ps.setString(1, emp_name);
            ps.setDate(2, java.sql.Date.valueOf(emp_doj));
            ps.setString(3, emp_sal);
            ps.setString(4, emp_dept);
            ps.setString(5, emp_gender);
            ps.setString(6, emp_address);
			ps.setString(7,emp_education);
			
            int result = ps.executeUpdate();
            if (result > 0) {
                out.println("<h2 style='color:green;'>Updated Employee Details Successfully!</h2>");
                %>
                	<script>
                		setTimeout(() => {
							window.location='List.jsp';
						}, 2000);
                	</script>
                <%
            } else {
                out.println("<h2 style='color:red;'>Failed to update the Employee Details.</h2>");
            }
            con.close();
        } catch (Exception e) {            
            e.printStackTrace();
        }
    }else{
%>
	<h1>Employee Application</h1>
    <form action="Update.jsp" method="post">
    	<%
    		String emp_id=request.getParameter("emp_id");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
        	String username = "system";
        	String password = "nuthan";
			
        	try{
        		Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection(url, username, password);
                String sql = "select * from java56e where emp_id=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, emp_id);
                ResultSet rs=ps.executeQuery();
                if(rs.next()){
                	String gender=rs.getString(6);
                	String dept=rs.getString(5);
                	String education=rs.getString(8);
         			List<String> seleducation = (education != null)
         				    ? Arrays.asList(education.split(","))
         				    : Collections.emptyList();

		%>
       	<input type="hidden" pattern="[0-9]{3}" name="emp_id" value="<%= rs.getInt(1) %>"/>
        Name : <input type="text" name="emp_name" value="<%= rs.getString(2) %>" required/><br/><br/>
        DOJ : <input type="date" name="emp_doj" required value="<%= rs.getDate(3) %>"/> <br/><br/>
        Salary : <input type="tel" pattern="[0-9]+" name="emp_sal" value="<%=rs.getInt(4) %>" required/><br/><br/>
        Department :
        <select name="emp_dept" required>
            <option <%= "Salesman".equalsIgnoreCase(dept) ? "selected" : "" %>>Salesman</option>
            <option <%= "Marketing".equalsIgnoreCase(dept) ? "selected" : "" %>>Marketing</option>
            <option <%= "HR".equalsIgnoreCase(dept) ? "selected" : "" %>>HR</option>
            <option <%= "Clerk".equalsIgnoreCase(dept) ? "selected" : "" %>>Clerk</option>
        </select><br/><br/>
        Gender :
        <input type="radio" name="emp_gender" value="Male" <%= gender.equalsIgnoreCase("Male") ? "checked" : "" %> required/> Male
        <input type="radio" name="emp_gender" value="Female" <%= gender.equalsIgnoreCase("female") ? "checked" : "" %>/> Female <br/><br/>
        Address : <input type="text" name="emp_address" value="<%=rs.getString(7) %>" required/> <br/><br/>
        Education :
        <input type="checkbox" name="emp_education" value="10th" <%= seleducation.contains("10th") ? "checked" : "" %>>10th class
        <input type="checkbox" name="emp_education" value="inter" <%= seleducation.contains("inter") ? "checked" : "" %>>Inter
        <input type="checkbox" name="emp_education" value="degree" <%= seleducation.contains("degree") ? "checked" : "" %>>Degree
        <input type="checkbox" name="emp_education" value="btech" <%= seleducation.contains("btech") ? "checked" : "" %>>B.Tech <br/><br/>
        <input type="submit" value="Submit"/> 
        <input type="button" value="Employee List" onclick="window.location='List.jsp'"/>                       
    </form>
 <% } 
 }catch(Exception e){
	 e.printStackTrace();	 
 }
 }
 %>
	
</body>
</html>