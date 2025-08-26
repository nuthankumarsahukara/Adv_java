package com.datapro;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class EditPage
 */
@WebServlet("/EditPage")
public class EditPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPage() {
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
		String std_id=request.getParameter("std_id");
		String url="jdbc:oracle:thin:@localhost:1521:xe";
        String username="system";
        String password="nuthan";
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection c =DriverManager.getConnection(url, username, password);
				String query="select * from java56s where std_id=?";
				PreparedStatement ps=c.prepareStatement(query);
				ps.setString(1, std_id);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					out.println("<html>");
					out.println("<head><link href='Style.css' rel='stylesheet'/></head");
					out.println("<body>");
					out.println("<form action='Update' method='post' enctype='multipart/form-data'>");
					out.println("<h1>Edit Student Details</h1>");
					out.println("Student ID : <input type='hidden' name='std_id' value='"+rs.getInt(1)+"'/>");
					out.println("Student Name: <input type='text' name='std_name' value='"+rs.getString(2)+"'/><br/><br/>");
					String gender=rs.getString(3);
					out.println("Student Gender : ");
					out.println("<input type='radio' name='std_gender' value='Male' "+("Male".equalsIgnoreCase(gender) ? "checked" : "" )+"/>Male");
					out.println("<input type='radio' name='std_gender' value='female' "+("female".equalsIgnoreCase(gender) ? "checked" : "" )+" />Female<br/><br/>");
					String course=rs.getString(4);
					out.println("Student Course : ");
					out.println("<select name='std_course'>");
						out.println("<option "+("Java Full Stack".equalsIgnoreCase(course) ? "selected" : "" )+" value='Java Full Stack'>Java Full Stack</option>");
						out.println("<option "+("Python Full Stack".equalsIgnoreCase(course) ? "selected" : "" )+" value='Python Full Stack'>Python Full Stack </option>");
						out.println("<option "+("MS Office".equalsIgnoreCase(course) ? "selected" : "" )+" value='MS Office'>MS Office</option>");
						out.println("<option "+("Power BI".equalsIgnoreCase(course) ? "selected" : "" )+" value='Power BI'>Power BI</option>");
						out.println("<option "+("DataScience".equalsIgnoreCase(course) ? "selected" : "" )+" value='DataScience'>DataScience</option>");
					out.println("</select> <br/><br/>");
					out.println("Student DOB : <input type='date' name='std_dob' value='"+rs.getDate(5)+"'/><br/><br/>");
					out.println("Student Qualification : <input type='text' name='std_qual' value='"+rs.getString(6)+"'/><br/><br/>");
					out.println("Student Course Fee : <input type='tel' pattern='[0-9]{4-9}' name='std_fee' value='"+rs.getInt(7)+"'/><br/><br/>");
					out.println("Student Phone Number : <input type='tel' pattern='[0-9]{10}' name='std_phone' value='"+rs.getLong(8)+"'/><br/><br/>");
					out.println("Student Photo (optional): <input type='file' name='std_photo'/><br/><br/>");
					out.println("Photo View : <img src='photo?std_id="+rs.getInt(1)+"' height=100 width=100 /><br/><br/>");
					out.println("<input type='submit' />");	
					
					out.println("</form>");
					out.println("</body></html>");
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
