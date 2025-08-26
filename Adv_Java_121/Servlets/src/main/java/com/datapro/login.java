package com.datapro;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
     
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String pwd=request.getParameter("password");
		
		System.out.println("Email : "+email);
		System.out.println("Password : "+pwd);
		
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="nuthan";
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection(url, username, password);
			String query="select * from java121r where email=? and password = ?";
			PreparedStatement ps=c.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, pwd);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				HttpSession session=request.getSession();
				session.setAttribute("email", email);
				String redirectURL = (String) session.getAttribute("redirectAfterLogin");
                if (redirectURL != null) {
                    session.removeAttribute("redirectAfterLogin"); 
                    response.sendRedirect(redirectURL);
                } else {
                	response.sendRedirect("Dashboard.html"); 
                }
				
			}else {
				out.println("<h1 style='color:red;text-align:center'>User Does Not Found....</h1>");
				out.println("<script>");
				out.println("setTimeout(()=>{window.location='Login.html'},3000);");
				out.println("</script>");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
