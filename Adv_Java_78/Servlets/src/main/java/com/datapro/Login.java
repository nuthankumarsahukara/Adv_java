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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname=request.getParameter("username");
		String pwd=request.getParameter("password");
		
		System.out.println("Username :"+uname);
		System.out.println("Password :"+pwd);
		
		PrintWriter out=response.getWriter();
		
		try {
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String username="system";
			String password="nuthan";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection(url, username, password);
			String query="select * from java78r where (email=? or phone=to_char(?)) and password=?";
			PreparedStatement ps=c.prepareStatement(query);
			ps.setString(1, uname);
			ps.setString(2, uname);
			ps.setString(3, pwd);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				HttpSession session=request.getSession();
				session.setAttribute("username", uname);
				String redirectURL = (String) session.getAttribute("redirectAfterLogin");
				if (redirectURL != null) {
                    session.removeAttribute("redirectAfterLogin"); 
                    response.sendRedirect(redirectURL);
                } else {
                response.sendRedirect("List"); 
                }
			}else {
				out.println("<h1 align='center' style='color:red;'>User Not Found.............</h1>");
				out.println("<script>");
				out.println("setTimeout(()=>window.location='Login.html',3000)");
				out.println("</script>");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
