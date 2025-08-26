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
		out.println("<div style=\"display: flex; justify-content: center; align-items: center; gap: 20px; margin-bottom: 30px;\">");
		out.println("<h1 align='center' style='margin:50px;'>Employee Details</h1>");
		out.println("<button onclick=\"window.location='Dashboard.html'\">Add Employee</button>");
		out.println("<button onclick=\"window.location='Logout'\">Logout</button>");
		out.println("</div>");
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="nuthan";
		out.println("<table border=2 rules='all' align='center' cellpadding='15px'>");
		
		out.println("<tr>");
			out.println("<th>emp_id</th>");
			out.println("<th>emp_name</th>");
			out.println("<th>emp_doj</th>");
			out.println("<th>emp_sal</th>");
			out.println("<th>emp_dept</th>");
			out.println("<th>emp_gender</th>");
			out.println("<th>emp_address</th>");
			out.println("<th>emp_photo</th>");
			out.println("<th colspan=2>Action</th>");
		out.println("</tr>");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection(url, username, password);
			Statement smt=c.createStatement();
			String query="select * from java121e";
			ResultSet rs=smt.executeQuery(query);
			while(rs.next()) {
				int emp_id=rs.getInt(1);
				out.println("<tr align='center'>");
					out.println("<td>"+rs.getInt(1)+"</td>");
					out.println("<td>"+rs.getString(2)+"</td>");
					out.println("<td>"+rs.getDate(3)+"</td>");
					out.println("<td>"+rs.getInt(4)+"</td>");
					out.println("<td>"+rs.getString(5)+"</td>");
					out.println("<td>"+rs.getString(6)+"</td>");
					out.println("<td>"+rs.getString(7)+"</td>");
					out.println("<td><img src='Photo?emp_id="+emp_id+"' width='100' height='100'/></td>");
					out.println("<td><a href='EditPage?emp_id="+emp_id+"'>Update</a></td>");
					out.println("<td><a href='List?action=delete&emp_id="+emp_id+"'>Delete</a></td>");
				out.println("<tr>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("</table>");
		String action= request.getParameter("action");
		if("delete".equals(action)) {
			String emp_id=request.getParameter("emp_id");
			System.out.println("Try delete the data");
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection co=DriverManager.getConnection(url, username, password);
				String query="delete from java121e where emp_id=?";
				PreparedStatement ps=co.prepareStatement(query);
				ps.setString(1, emp_id);
				ps.execute();
				response.sendRedirect("List");
			}catch(Exception e) {
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
