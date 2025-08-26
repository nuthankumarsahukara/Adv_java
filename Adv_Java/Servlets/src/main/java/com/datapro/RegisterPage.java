package com.datapro;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet("/RegisterPage")
public class RegisterPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegisterPage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Get");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String phonenumber=request.getParameter("phonenumber");
		
		System.out.println(name);
		System.out.println(email);
		System.out.println(password);
		System.out.println(phonenumber);
		PrintWriter out=response.getWriter();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521/xe";
			String username="system";
			String password1="nuthan";
			Connection con=DriverManager.getConnection(url,username,password1);
			String query="insert into register values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.setString(4, phonenumber);
			int result=ps.executeUpdate();
			if(result>0) {
				response.setContentType("text/html");
				out.println("<h1>Registration Successful ....</h1>");
				out.println("<script>");
				out.println("setTimeout(()=>{window.location='Login.html'},5000)");
				out.println("</script>");
				out.println("Redirection to Login Page automatically....");
			}else {
				out.println("<h1 style='color:red'>Something Went Wrong</h1>");
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
