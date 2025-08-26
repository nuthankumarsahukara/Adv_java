package com.datapro;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");		
		System.out.println(email);
		System.out.println(password);
		PrintWriter out=response.getWriter();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521/xe";
			String username="system";
			String password1="nuthan";
			Connection con=DriverManager.getConnection(url,username,password1);
			String query="Select * from register where email=? and password=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				System.out.println("User Found :"+rs.getString("email"));
				HttpSession session=request.getSession();
				session.setAttribute("email", email);
				String redirectURL = (String) session.getAttribute("redirectAfterLogin");
                if (redirectURL != null) {
                    session.removeAttribute("redirectAfterLogin"); 
                    response.sendRedirect(redirectURL);
                } else {
                    response.sendRedirect("NewFile.html"); 
                }
			}else {
				out.println("<h1 style='color:red'>User Not Found please try again...</h1>");
				out.println("<script>");
				out.println("setTimeout(()=>{window.location='Login.html'},3000)");
				out.println("</script>");
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
