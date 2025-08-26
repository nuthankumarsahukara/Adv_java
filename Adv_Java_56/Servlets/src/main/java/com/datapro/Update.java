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
import jakarta.servlet.http.Part;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
@MultipartConfig(maxFileSize = 1650000)
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
		String std_id=request.getParameter("std_id");
		String std_name=request.getParameter("std_name");
		String std_gender=request.getParameter("std_gender");
		String std_course=request.getParameter("std_course");
		String std_dob=request.getParameter("std_dob");
		String std_qual=request.getParameter("std_qual");
		String std_phone=request.getParameter("std_phone");
		String std_fee=request.getParameter("std_fee");
		Part std_photo=request.getPart("std_photo");
		InputStream inputStream=null;
		if(std_photo !=null && std_photo.getSize()>0) {
			inputStream=std_photo.getInputStream();
		}
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="nuthan";
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection(url, username, password);
			PreparedStatement ps=null;
			if(inputStream !=null) {
				String query="update java56s set std_name=?,std_gender=?,std_course=?,std_dob=?,std_qual=?,std_fee=?,std_phone=?,std_photo=? where std_id=?";
				ps=c.prepareStatement(query);
				ps.setString(9, std_id);
				ps.setString(1, std_name);
				ps.setString(2, std_gender);
				ps.setString(3, std_course);
				Date date=Date.valueOf(std_dob);
				ps.setDate(4, date);
				ps.setString(5, std_qual);
				ps.setString(6, std_fee);
				ps.setString(7, std_phone);
				ps.setBlob(8, inputStream);
			}else {
				String query="update java56s set std_name=?,std_gender=?,std_course=?,std_dob=?,std_qual=?,std_fee=?,std_phone=? where std_id=?";
				ps=c.prepareStatement(query);
				ps.setString(8, std_id);
				ps.setString(1, std_name);
				ps.setString(2, std_gender);
				ps.setString(3, std_course);
				Date date=Date.valueOf(std_dob);
				ps.setDate(4, date);
				ps.setString(5, std_qual);
				ps.setString(6, std_fee);
				ps.setString(7, std_phone);
			}
			int rows=ps.executeUpdate();
			
			if(rows>0) {
				out.println("<h1>Data Updated Successfully.....</h1>");
				out.println("<script>");
				out.println("setTimeout(()=>{window.location='List'} ,2000)");
				out.println("</script>");
			}else {
				out.println("Data not submitted Successfully.....");
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
