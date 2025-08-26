<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Employee Portal</title>
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
    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String emp_id =request.getParameter("emp_id");
        String emp_name = request.getParameter("emp_name");
        String emp_doj = request.getParameter("emp_doj");
        String emp_sal = request.getParameter("emp_sal");
        String emp_dept = request.getParameter("emp_dept");
        String emp_gender = request.getParameter("emp_gender");
        String emp_address = request.getParameter("emp_address");
        String[] education=request.getParameterValues("emp_education");
        String emp_education = (education != null) ? String.join(",", education) : "";        		
		
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "system";
        String password = "nuthan";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(url, username, password);

            String sql = "INSERT INTO java56e VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, emp_id);
            ps.setString(2, emp_name);
            ps.setDate(3, java.sql.Date.valueOf(emp_doj));
            ps.setString(4, emp_sal);
            ps.setString(5, emp_dept);
            ps.setString(6, emp_gender);
            ps.setString(7, emp_address);
			ps.setString(8,emp_education);
            int result = ps.executeUpdate();
            if (result > 0) {
                out.println("<h2 style='color:green;'>Employee Added Successfully!</h2>");
                %>
                	<script>
                		setTimeout(() => {
							window.location='List.jsp';
						}, 2000);
                	</script>
                <%
            } else {
                out.println("<h2 style='color:red;'>Failed to Add Employee.</h2>");
            }
            con.close();
        } catch (Exception e) {            
            e.printStackTrace();
        }
    }else{
%>
	<div class="box">
	<h1>Employee Application</h1>
	<button onclick="window.location='List.jsp'">All Employee List</button>
	</div>
    <form action="Dashboard.jsp" method="post">
        ID : <input type="tel" pattern="[0-9]{3}" name="emp_id" required/> <br/><br/>
        Name : <input type="text" name="emp_name" required/><br/><br/>
        DOJ : <input type="date" name="emp_doj" required/> <br/><br/>
        Salary : <input type="tel" pattern="[0-9]+" name="emp_sal" required/><br/><br/>
        Department :
        <select name="emp_dept" required>
            <option value="">--Select--</option>
            <option>Salesman</option>
            <option>Marketing</option>
            <option>HR</option>
            <option>Clerk</option>
        </select><br/><br/>
        Gender :
        <input type="radio" name="emp_gender" value="Male" required/> Male
        <input type="radio" name="emp_gender" value="Female"/> Female <br/><br/>
        Address : <input type="text" name="emp_address" required/> <br/><br/>
        Education :
        <input type="checkbox" name="emp_education" value="10th">10th class
        <input type="checkbox" name="emp_education" value="inter">Inter
        <input type="checkbox" name="emp_education" value="degree">Degree
        <input type="checkbox" name="emp_education" value="btech">B.Tech <br/><br/>
        <input type="submit" value="Submit"/>
    </form>
 <% } %>
</body>
</html>