package com.datapro;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
@MultipartConfig(maxFileSize = 1650000)
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(false);
		if(session==null || session.getAttribute("email")==null) {
			session = request.getSession();
            session.setAttribute("redirectAfterLogin", "List");
            response.sendRedirect("Login.html");
		return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(false);
		if(session==null || session.getAttribute("email")==null) {		
		response.sendRedirect("Login.html");
		return;
		}
		
		String std_id=request.getParameter("std_id");
		String std_name=request.getParameter("std_name");
		String std_gender=request.getParameter("std_gender");
		String std_course=request.getParameter("std_course");
		String std_dob=request.getParameter("std_dob");
		String std_qual=request.getParameter("std_qual");
		String std_phone=request.getParameter("std_phone");
		String std_fee=request.getParameter("std_fee");
		InputStream inputStream=null;
		Part std_photo=null;
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="nuthan";
		try {
			std_photo=request.getPart("std_photo");
			if(std_photo !=null) {
				inputStream=std_photo.getInputStream();
			}
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection(url, username, password);
			String query="insert into java56s values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=c.prepareStatement(query);
			ps.setString(1, std_id);
			ps.setString(2, std_name);
			ps.setString(3, std_gender);
			ps.setString(4, std_course);
			Date date=Date.valueOf(std_dob);
			ps.setDate(5, date);
			ps.setString(6, std_qual);
			ps.setString(7, std_fee);
			ps.setString(8, std_phone);
			if(inputStream !=null) {
				ps.setBlob(9, inputStream);
			}
			int rows=ps.executeUpdate();
			
			if(rows>0) {
				out.println("<h1>Data submitted Successfully.....</h1>");
				out.println("<script>");
				out.println("setTimeout(()=>{window.location='List'} ,3000)");
				out.println("</script>");
			}else {
				out.println("Data not submitted Successfully.....");
			}			
		}catch(Exception e) {
			e.printStackTrace();
			out.println("<h1>"+e.getMessage()+"</h1>");
		}
		System.out.println("Student ID : "+std_id);
		System.out.println("Student Name : "+std_name);
		System.out.println("Student Gender : "+std_gender);
		System.out.println("Student Course : "+std_course);
		System.out.println("Student DOB : "+std_dob);
		System.out.println("Student Qualification : "+std_qual);
		System.out.println("Student Fees : "+std_fee);
		System.out.println("Student Phone Number : "+std_phone);
		System.out.println("Student Photo : "+std_photo);
		
	}

}
