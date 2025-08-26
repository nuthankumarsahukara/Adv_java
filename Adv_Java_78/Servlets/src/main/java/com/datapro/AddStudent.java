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
@MultipartConfig(maxFileSize = 16506532)
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
		if(session==null || session.getAttribute("username")==null) {
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
		if(session==null || session.getAttribute("username")==null) {
			session = request.getSession();
            session.setAttribute("redirectAfterLogin", "List");
            response.sendRedirect("Login.html");
		return;
		}
		String std_id=request.getParameter("std_id");
		String std_name=request.getParameter("std_name");
		String std_email=request.getParameter("std_email");
		String std_dob=request.getParameter("std_dob");
		String std_gender=request.getParameter("std_gender");
		String std_course=request.getParameter("std_course");
		String std_phone=request.getParameter("std_phone");
		InputStream inputStream=null;
		Part filepath=null;
		
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
		
		PrintWriter out=response.getWriter();
		
		try {
			filepath=request.getPart("std_photo");
			if(filepath !=null) {
				inputStream=filepath.getInputStream();
			}
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection(url, username, password);
			String query="insert into java78s values (?,?,?,?,?,?,?,?)";
			PreparedStatement ps=c.prepareStatement(query);
			ps.setString(1, std_id);
			ps.setString(2, std_name);
			ps.setString(3, std_email);
			Date date=Date.valueOf(std_dob);
			ps.setDate(4, date);
			ps.setString(5, std_gender);
			ps.setString(6, std_course);
			ps.setString(7, std_phone);
			if(inputStream != null) {
				ps.setBlob(8, inputStream);
			}
			int rows=ps.executeUpdate();
			if(rows>0) {
				out.println("<h1>Data Submitted Successfully.......</h1>");
				out.println("<script>");
				out.println("setTimeout(()=>{window.location='List'},3000)");
				out.println("</script>");
			}else {
				out.println("<h1>Data Not Submitted Successfully.......</h1>");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
