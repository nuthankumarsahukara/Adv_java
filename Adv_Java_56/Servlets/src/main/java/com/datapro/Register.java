package com.datapro;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
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
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String dob=request.getParameter("dob");
		String phone=request.getParameter("phone");
		String password=request.getParameter("password");
		
		System.out.println("Name : "+name);
		System.out.println("Email : "+email);
		System.out.println("DOB : "+dob);
		System.out.println("Phone Number : "+phone);
		System.out.println("Password : "+password);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String pwd="nuthan";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(url,username, pwd);
			String query="insert into java56r values(?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.setString(4, phone);
			Date sqlDob = Date.valueOf(dob);
			ps.setDate(5, sqlDob);
			
			int row=ps.executeUpdate();
			if(row>0) {
				out.println("<h1 align='center'>Data Submitted Successfully.........</h1>");
			}else {
				out.println("<h1 align='center'>Something went wrong.........</h1>");
			}
			ps.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
