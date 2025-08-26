package com.datapro;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class List
 */
@WebServlet("/List")
public class List extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public List() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		if(session==null || session.getAttribute("username")==null) {
			session = request.getSession();
            session.setAttribute("redirectAfterLogin", "List");
            response.sendRedirect("Login.html");
		return;
		}
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="nuthan";
		out.println("<h1 align='center'>Student Details</h1>");
		out.println("<table border='1' align='center' rules='all'>");
		out.println("<tr>");
			out.println("<th>Student_ID</th>");
			out.println("<th>Student_Name</th>");
			out.println("<th>Student_Email</th>");
			out.println("<th>Student_DOB</th>");
			out.println("<th>Student_Gender</th>");
			out.println("<th>Student_Course</th>");
			out.println("<th>Student_PhoneNumber</th>");
			out.println("<th>Student_Photo</th>");
			out.println("<th colspan=2>Action</th>");
		out.println("</tr>");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection(url, username, password);
			Statement smt=c.createStatement();
			ResultSet rs=smt.executeQuery("select * from java78s");
			while(rs.next()) {
				out.println("<tr align='center'>");
				out.println("<td>"+rs.getInt(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				out.println("<td>"+rs.getDate(4)+"</td>");
				out.println("<td>"+rs.getString(5)+"</td>");
				out.println("<td>"+rs.getString(6)+"</td>");
				out.println("<td>"+rs.getLong(7)+"</td>");	
				out.println("<td><img src='Photo?std_id="+rs.getInt(1)+"' width='100px' heigth='100px'/></td>");		
				out.println("<td><a href='EditPage?std_id="+rs.getInt(1)+"'>Update</a></td>");
				out.println("<td><a href='List?action=delete&std_id="+rs.getInt(1)+"'>Delete</a></td>");
				out.println("</tr>");
			}
			out.println("</table>");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		String action=request.getParameter("action");
			if("delete".equals(action)) {
				int std_id=Integer.parseInt(request.getParameter("std_id"));
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection c=DriverManager.getConnection(url, username, password);
					String query="delete from java78s where std_id=?";
					PreparedStatement ps=c.prepareStatement(query);
					ps.setInt(1, std_id);
					int rows=ps.executeUpdate();
					if(rows>0) {
						System.out.println("Data Deleted Successfully");
					}else {
						System.out.println("Data Not Deleted Successfully..");
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
				response.sendRedirect("List");
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
