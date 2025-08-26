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
 * Servlet implementation class addEmp
 */
@WebServlet("/addEmp")
@MultipartConfig(maxFileSize = 16177215)
public class addEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addEmp() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		if(session==null || session.getAttribute("email")==null) {		
			response.sendRedirect("Login.html");
			return;
		}
		String emp_id=request.getParameter("emp_id");
		String emp_name=request.getParameter("emp_name");
		String emp_doj=request.getParameter("emp_doj");
		String emp_sal=request.getParameter("emp_sal");
		String emp_dept=request.getParameter("emp_dept");
		String emp_gender=request.getParameter("emp_gender");
		String emp_address=request.getParameter("emp_address");
		InputStream inputStream = null;
        Part filePart = null;
        PrintWriter out=response.getWriter();
        
        String url="jdbc:oracle:thin:@localhost:1521:xe";
        String username="system";
        String password="nuthan";
        try {
        	filePart = request.getPart("emp_photo");
        	if (filePart != null) {
                inputStream = filePart.getInputStream();
            }
        	
        	Class.forName("oracle.jdbc.driver.OracleDriver");
        	Connection c=DriverManager.getConnection(url, username, password);
        	String query="insert into java121e values(?,?,?,?,?,?,?,?)";
        	PreparedStatement ps=c.prepareStatement(query);
        	ps.setString(1, emp_id);
        	ps.setString(2, emp_name);
        	Date date=Date.valueOf(emp_doj);
        	ps.setDate(3, date);
        	ps.setString(4,emp_sal);
        	ps.setString(5,emp_dept);
        	ps.setString(6,emp_gender);
        	ps.setString(7,emp_address);
        	if (inputStream != null) {
                ps.setBlob(8, inputStream);
            }
        	int rows=ps.executeUpdate();
        	if(rows>0) {
        		out.println("<h1>Data Submitted Successfully....</h1>");
        		out.println("<script>");
        		out.println("setTimeout(()=>{window.location='List'},3000);");
        		out.println("</script>");
        	}
        }catch (Exception e) {
            e.printStackTrace();
        }
		System.out.println("ID : "+emp_id);
		System.out.println("Name : "+emp_name);
		System.out.println("DOJ : "+emp_doj);
		System.out.println("Salary : "+emp_sal);
		System.out.println("Department : "+emp_dept);
		System.out.println("Gender : "+emp_gender);
		System.out.println("Address : "+emp_address);
		System.out.println("Photo :"+filePart);
	}

}
