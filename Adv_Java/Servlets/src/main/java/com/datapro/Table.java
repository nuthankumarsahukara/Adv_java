package com.datapro;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Table")
public class Table extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Table() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		if(session==null || session.getAttribute("email")==null) {
			session = request.getSession();
            session.setAttribute("redirectAfterLogin", "Table");
            response.sendRedirect("Login.html");
		return;
	}
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521/xe";
			String username="system";
			String password="nuthan";
			Connection con=DriverManager.getConnection(url,username,password);
			String query="select * from servlets";
			Statement smt=con.createStatement();
			ResultSet rs=smt.executeQuery(query);
			
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("<p align='right'><a href='Logout'>Logout</a></p>");
			out.println("<table border='1px' align='center' rules='all'>");
				out.println("<tr>");
					out.println("<th>Id</th>");
					out.println("<th>Name</th>");
					out.println("<th>Father Name </th>");	
					out.println("<th>Mother Name </th>");
					out.println("<th>Gender</th>");
					out.println("<th>Action</th>");
				out.println("</tr>");
				while(rs.next()) {
				out.println("<tr>");
				out.println("<td>"+rs.getInt(5)+"</td>");
				out.println("<td>"+rs.getString(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");	
				out.println("<td>"+rs.getString(3)+"</td>");
				out.println("<td>"+rs.getString(4)+"</td>");
				out.println("<td><a href='EditPage?id="+ rs.getInt(5) +"'>Edit</a>"+
				"<a href='Table?action=delete&id=" + rs.getInt(5) +"'>Delete</a></td>");
				}
			out.println("</tr>");
			out.println("</table>");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		String action=request.getParameter("action");
		if("delete".equals(action)){
			String id=request.getParameter("id");
			try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521/xe";
			String username="system";
			String password="nuthan";
			Connection con=DriverManager.getConnection(url,username,password);
			String query="delete from servlets where id =?";
			PreparedStatement psmt=con.prepareStatement(query);
			psmt.setString(1, id);
			int row=psmt.executeUpdate();
			if(row>0) {
				System.out.println("Record Delete successfully....");
			}
			psmt.close();
			con.close();
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			response.sendRedirect("Table");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

	    if ("update".equals(action)) {
	    	String id= request.getParameter("id");
	        String name = request.getParameter("name");
	        String fname = request.getParameter("fname");
	        String mname = request.getParameter("mname");
	        String gender = request.getParameter("gender");

	        try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "nuthan");
	            String updateQuery = "UPDATE servlets SET name = ?, father_name = ?, mother_name = ?, gender = ? WHERE id = ?";
	            PreparedStatement pst = con.prepareStatement(updateQuery);
	            pst.setString(1, name);
	            pst.setString(2, fname);
	            pst.setString(3, mname);
	            pst.setString(4, gender);
	            pst.setString(5, id);
	            pst.executeUpdate();
	            System.out.println("Record updated successfully.");
	            pst.close();
	            con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        response.sendRedirect("Table"); 
	    }
	}

}
