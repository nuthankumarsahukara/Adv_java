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
		HttpSession session=request.getSession(false);
		if(session==null || session.getAttribute("email")==null) {
			session = request.getSession();
            session.setAttribute("redirectAfterLogin", "List");
            response.sendRedirect("Login.html");
		return;
		}		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String emp_id=request.getParameter("emp_id");
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="nuthan";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection(url,username,password);
			String query="select * from java121e where emp_id=?";
			PreparedStatement ps=c.prepareStatement(query);
			ps.setString(1, emp_id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				out.println("<html><body>");
                out.println("<h2>Edit Employee</h2>");
				out.println("<form action='Update' method='post' enctype='multipart/form-data'>");
				out.println("<input type='hidden' name='emp_id' value='"+rs.getInt(1)+"'/>");
				out.println("Name :<input type='text' name='emp_name' value='"+rs.getString(2)+"'/><br/><br/>");
				out.println("DOJ : <input type='date' name='emp_doj' value='"+rs.getDate(3)+"'/> <br/><br/>");
				out.println("Salary :<input type='tel' pattern='[0-9]{4-6}' name='emp_sal' value='"+rs.getInt(4)+"'/><br/><br/>");
				String emp_dept=rs.getString(5);
				out.println("Department : ");
				out.println("<select name='emp_dept'> ");
					out.println("<option "+ ("Salesman".equalsIgnoreCase(emp_dept) ? " selected" : "") +">Salesman</option> ");
					out.println("<option "+ ("Marketing".equalsIgnoreCase(emp_dept) ? " selected" : "") +">Marketing</option> ");
					out.println("<option "+ ("HR".equalsIgnoreCase(emp_dept) ? " selected" : "") +">HR</option> ");
					out.println("<option "+ ("Clerk".equalsIgnoreCase(emp_dept) ? " selected" : "") +">Clerk</option> ");
				out.println("</select><br/><br/> ");
				String gender=rs.getString(6);
				out.println("Gender : <input type='radio' name='emp_gender' value='Male'"+(gender.equals("Male")? "checked" :"")+"/> Male ");
				out.println("<input type='radio' name='emp_gender' value='Female'"+(gender.equals("Female")? "checked" :"")+"/> Female <br/><br/>");
				out.println("Address : <input type='text' name='emp_address' value='"+rs.getString(7)+"'/> <br/><br/> ");
				out.println("Photo (Optional):<input type='file' name='emp_photo' /> <br/><br/>");
				out.println("Photo View :<img src='Photo?emp_id="+emp_id+"' heigth=100 width=100/><br/><br/>");
				out.println("<input type='submit' Value='Update Details'/>");
				out.println("</form>");
				 out.println("</body></html>");
			}else {
				out.println("<p>No Employee found with ID: " + emp_id + "</p>");
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
		doGet(request, response);
	}

}
