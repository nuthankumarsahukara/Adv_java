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
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(false);
		if(session==null || session.getAttribute("email")==null) {
			session = request.getSession();
            session.setAttribute("redirectAfterLogin", "List");
            response.sendRedirect("Login.html");
		return;
		}
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<div style='display:flex;justify-content:space-around;align-items:center;'>");
		out.println("<h1 align='center' style='margin : 20px'>Student Details</h1>");
		out.println("<div>");
		out.println("<button onclick=\"window.location='Dashboard.html'\">Add Students</button>");
		out.println("<button onclick=\"window.location='Logout'\">Logout</button>");
		out.println("</div>");
		out.println("</div>");
		out.println("<table border='2px' rules='all' align='center' cellpadding='15px'>");
			out.println("<tr>");
				out.println("<th>Student ID</th>");
				out.println("<th>Student Name </th>");
				out.println("<th>Student Gender </th>");
				out.println("<th>Student Course </th>");
				out.println("<th>Student DOB </th>");
				out.println("<th>Student Qualification </th>");
				out.println("<th>Student Fees </th>");
				out.println("<th>Student Phone Number </th>");
				out.println("<th>Student Photo </th>");
				out.println("<th colspan=2>Action</th>");
			out.println("</tr>");
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String username="system";
			String password="nuthan";
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection c =DriverManager.getConnection(url, username, password);
				String query="select * from java56s";
				Statement smt=c.createStatement();
				ResultSet rs=smt.executeQuery(query);
				while(rs.next()) {
					out.println("<tr align='center'>");
						out.println("<td>"+rs.getInt(1)+"</td>");
						out.println("<td>"+rs.getString(2)+"</td>");
						out.println("<td>"+rs.getString(3)+"</td>");
						out.println("<td>"+rs.getString(4)+"</td>");
						out.println("<td>"+rs.getDate(5)+"</td>");
						out.println("<td>"+rs.getString(6)+"</td>");
						out.println("<td>"+rs.getInt(7)+"</td>");
						out.println("<td>"+rs.getLong(8)+"</td>");
						out.println("<td><img src='photo?std_id="+rs.getInt(1)+"' height=100 width=100/></td>");
						out.println("<td><a href='EditPage?std_id="+rs.getInt(1)+"'>Update</a></td>");
						out.println("<td><a href='List?action=delete&std_id="+rs.getInt(1)+"'>Delete</a></td>");
					out.println("</tr>");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			String action=request.getParameter("action");
			String std_id=request.getParameter("std_id");
			if("delete".equals(action)) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection c =DriverManager.getConnection(url, username, password);
					String query="delete from java56s where std_id=?";
					PreparedStatement ps=c.prepareStatement(query);
					ps.setString(1, std_id);
					ResultSet rs=ps.executeQuery();
					
					response.sendRedirect("List");
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
