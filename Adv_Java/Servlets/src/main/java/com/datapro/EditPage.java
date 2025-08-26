package com.datapro;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EditPage")
public class EditPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditPage() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String id=request.getParameter("id");
			String url="jdbc:oracle:thin:@localhost:1521/xe";
			String username="system";
			String password="nuthan";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(url,username,password);
			String query="select * from servlets where id= ? ";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			if(rs.next()) {
				out.println("<form action='Table' method='post'>");
                out.println("<label>Application No</label>");
                out.println("<input type='text' name='id' value='" + rs.getInt(5) + "' readonly /><br>");
                out.println("<label>Name :</label>");
                out.println("<input type='text' name='name' value='" + rs.getString(1) + "' /><br>");
                out.println("<label>Father Name:</label>");
                out.println("<input type='text' name='fname' value='" + rs.getString(2) + "' /><br>");
                out.println("<label>Mother Name:</label>");
                out.println("<input type='text' name='mname' value='" + rs.getString(3) + "' /><br>");
                out.println("<label>Gender:</label>");
                String gender = rs.getString(4);
                out.println("<input type='radio' name='gender' value='male' " + (gender.equals("male") ? "checked" : "") + " />Male");
                out.println("<input type='radio' name='gender' value='female' " + (gender.equals("female") ? "checked" : "") + "/>Female<br>");
                out.println("<input type='submit' value='Save Changes' />");
                out.println("<input type='hidden' name='action' value='update' />");
                out.println("<input type='hidden' name='original_name' value='" + rs.getInt(5) + "' />");
                out.println("</form>");
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
