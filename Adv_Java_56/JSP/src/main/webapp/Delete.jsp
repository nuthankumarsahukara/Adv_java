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
	    out.println("<meta http-equiv='refresh' content='2; URL=Login.jsp'>");
	    return;
	}
%>
<%
			String emp_id=request.getParameter("emp_id");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
        	String username = "system";
        	String password = "nuthan";
			
        	try{
        		Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection(url, username, password);
                String sql = "delete from java56e where emp_id=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, emp_id);
                int rows=ps.executeUpdate();
                if(rows>0){
                	%>
                		<script>
                			setTimeout(() => {
								window.location='List.jsp'
							}, 0);
                		</script>
                	<%
                }                
                ps.close();
                con.close();
        	}catch(Exception e){
        		e.printStackTrace();
        	}
%>
</body>
</html>