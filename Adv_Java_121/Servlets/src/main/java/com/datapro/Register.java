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


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();		
		
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String dob=request.getParameter("dob");
		String gender=request.getParameter("gender");
		String phone=request.getParameter("phone");
		String pwd=request.getParameter("password");
		
		System.out.println("Name : "+name);
		System.out.println("Email : "+email);
		System.out.println("DOB : "+dob);
		System.out.println("Gender : "+gender);
		System.out.println("Phone Number : "+phone);
		
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="nuthan";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection(url, username, password);
			String query="insert into java121r values(?,?,?,?,?,?)";
			PreparedStatement ps=c.prepareStatement(query);
			ps.setString(1,name);
			ps.setString(2, email);
			Date date =Date.valueOf(dob);
			ps.setDate(3, date);
			ps.setString(4, gender);
			ps.setString(5, phone);
			ps.setString(6, pwd);
			int rows=ps.executeUpdate();
			if(rows>0) {
				out.println("<h1>Data Submitted Successfully....</h1>");
			}else {
				out.println("<h1>Something went wrong....</h1>");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
