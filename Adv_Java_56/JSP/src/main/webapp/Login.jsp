<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<%
	if ("POST".equalsIgnoreCase(request.getMethod())) {
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUser = "system";
		String dbPass = "nuthan";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, dbUser, dbPass);

			String query = "SELECT * FROM java56jr WHERE (email = ? OR TO_CHAR(phone) = ?) AND password = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, uname); // either email or phone
			ps.setString(2, uname);
			ps.setString(3, pwd);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				session.setAttribute("loggedInUser",  rs.getString("name"));
%>
				<h1>Login successful...</h1>
				<script>
					setTimeout(() => { window.location = 'List.jsp'; }, 3000);
				</script>
<%
			} else {
%>
				<h1>User not found...</h1>
				<script>
					setTimeout(() => { window.location = 'Login.jsp'; }, 3000);
				</script>
<%
			}
			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} else {
%>
	<form action="Login.jsp" method="post">
		<label>Email or Phone:</label> <input type="text" name="uname"/><br/><br/>
		<label>Password:</label> <input type="password" name="pwd"/><br/><br/>
		<input type="submit" value="Login"/>
	</form>
<% } %>
</body>
</html>
