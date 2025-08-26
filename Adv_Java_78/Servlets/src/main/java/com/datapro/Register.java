package com.datapro;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Register() {
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
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String gender=request.getParameter("gender");
		String password=request.getParameter("password");
		
		
		System.out.println("Name  : "+name);
		System.out.println("Email :"+email);
		System.out.println("Phone Number :"+phone);
		System.out.println("Gender :"+gender);
		System.out.println("Password :"+password);
		
		PrintWriter out=response.getWriter();
		out.println("<h1>Data Submitted Successfully............</h1>");
		
		try {
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String username="system";
			String pwd="nuthan";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver classs founded..............");
			Connection c=DriverManager.getConnection(url, username, pwd);
			System.out.println("Database Connected Successfully.......");
			String query="insert into java78r values (?,?,?,?,?)";
			PreparedStatement ps=c.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, phone);
			ps.setString(4, gender);
			ps.setString(5, password);
			ps.execute();
			ps.close();
			c.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
