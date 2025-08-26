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
		if(session==null || session.getAttribute("username")==null) {
			session = request.getSession();
            session.setAttribute("redirectAfterLogin", "List");
            response.sendRedirect("Login.html");
		return;
		}
		
		int std_id=Integer.parseInt(request.getParameter("std_id"));
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try {
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String username="system";
			String password="nuthan";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection(url, username, password);
			PreparedStatement ps=c.prepareStatement("select * from java78s where std_id=?");
			ps.setInt(1,std_id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				out.println("<h1>Edit Students Details</h1>");
				out.println("<form action='Update' method='post' enctype='multipart/form-data'>");
					out.println("<input type='hidden' name='std_id' value="+rs.getInt(1)+">");
					out.println("Student Name :<input type='text' name='std_name' value="+rs.getString(2)+" ><br/><br/>");
					out.println("Student Email :<input type='email' name='std_email' value="+rs.getString(3)+" ><br/><br/>");
					out.println("Student DOB :<input type='date' name='std_dob' value="+rs.getDate(4)+"><br/><br/>");
					out.println("Student Gender :");
					String gender=rs.getString(5);
					out.println("<input type='radio' name='std_gender' value='Male'"+(gender.equals("Male")?"checked":"")+" />Male    ");
					out.println("<input type='radio' name='std_gender' value='Female'"+(gender.equals("Female")?"checked":"")+"/>Female<br/><br/>");
					String course=rs.getString(6);
					out.println("Student Course :");
					out.println("<input type='checkbox' name='std_course' value='Java Full Stack'"+(course.equals("Java Full Stack")?"checked":"")+ "/>Java Full Stack");
					out.println("<input type='checkbox' name='std_course' value='Python Full Stack'"+(course.equals("Python Full Stack")?"checked":"")+ " />Python Full Stack");
					out.println("<input type='checkbox' name='std_course' value='Power BI'"+(course.equals("Power BI")?"checked":"")+ "/>Power BI");
					out.println("<input type='checkbox' name='std_course' value='AI'"+(course.equals("AI")?"checked":"")+ "/>AI");
					out.println("<input type='checkbox' name='std_course' value='MS Office'"+(course.equals("MS Office")?"checked":"")+ "/>MS Office <br/><br/>");
					out.println("Student Phone Number :<input type='tel' pattern='[0-9]{10}' name='std_phone' value="+rs.getLong(7)+"><br/><br/>");
					out.println("Student Photo (optional):<input type='file' name='std_photo' /><br/><br/>");
					out.println("Current Photo : <img src='Photo?std_id="+rs.getInt(1)+"' width='100px' heigth='100px'/> <br/><br/>");
				out.println("<input type='submit' />");
				out.println("</form>");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
