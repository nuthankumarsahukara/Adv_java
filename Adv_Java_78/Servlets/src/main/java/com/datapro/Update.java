package com.datapro;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
@MultipartConfig
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String std_id=request.getParameter("std_id");
		String std_name=request.getParameter("std_name");
		String std_email=request.getParameter("std_email");
		String std_dob=request.getParameter("std_dob");
		String std_gender=request.getParameter("std_gender");
		String std_course=request.getParameter("std_course");
		String std_phone=request.getParameter("std_phone");
		Part std_photo=request.getPart("std_photo");
		InputStream inputStream=null;
		if(std_photo !=null && std_photo.getSize()>0) {
			inputStream=std_photo.getInputStream();
		}
		
		System.out.println("Student ID :"+std_id);
		System.out.println("Student Name :"+std_name);
		System.out.println("Student Email :"+std_email);
		System.out.println("Student DOB :"+std_dob);
		System.out.println("Student Gender :"+std_gender);
		System.out.println("Student Course :"+std_course);
		System.out.println("Student Phone Number :"+std_phone);
		
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="nuthan";
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection(url, username, password);
			PreparedStatement ps=null;	
			if(inputStream !=null) {
				String query="update java78s set std_name=?,std_email=?,std_dob=?,std_gender=?,std_course=?,std_phone=?,std_photo=? where std_id=?";
				ps=c.prepareStatement(query);
				ps.setString(1, std_name);
				ps.setString(2, std_email);
				Date date=Date.valueOf(std_dob);
				ps.setDate(3, date);
				ps.setString(4, std_gender);
				ps.setString(5, std_course);
				ps.setString(6, std_phone);
				ps.setBlob(7, inputStream);
				ps.setString(8, std_id);
			}else {
				String query="update java78s set std_name=?,std_email=?,std_dob=?,std_gender=?,std_course=?,std_phone=? where std_id=?";
				ps=c.prepareStatement(query);
				ps.setString(1, std_name);
				ps.setString(2, std_email);
				Date date=Date.valueOf(std_dob);
				ps.setDate(3, date);
				ps.setString(4, std_gender);
				ps.setString(5, std_course);
				ps.setString(6, std_phone);
				ps.setString(7, std_id);
			}
			int rows=ps.executeUpdate();
			if(rows>0) {
				out.println("<h1>Data Updated Successfully.......</h1>");
				out.println("<script>");
				out.println("setTimeout(()=>{window.location='List'},3000)");
				out.println("</script>");
			}else {
				out.println("<h1>Data Not Updated Successfully.......</h1>");
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
