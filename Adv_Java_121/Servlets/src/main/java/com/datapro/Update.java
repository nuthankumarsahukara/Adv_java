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
@MultipartConfig(maxFileSize = 16177215)
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
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emp_id=request.getParameter("emp_id");
		String emp_name=request.getParameter("emp_name");
		String emp_doj=request.getParameter("emp_doj");
		String emp_sal=request.getParameter("emp_sal");
		String emp_dept=request.getParameter("emp_dept");
		String emp_gender=request.getParameter("emp_gender");
		String emp_address=request.getParameter("emp_address");
        Part filePart = request.getPart("emp_photo");
        
        InputStream inputStream = null;
        if (filePart != null && filePart.getSize() > 0) {
            inputStream = filePart.getInputStream();
        }
        
        PrintWriter out=response.getWriter();
        
        String url="jdbc:oracle:thin:@localhost:1521:xe";
        String username="system";
        String password="nuthan";
        try {    	
        	Class.forName("oracle.jdbc.driver.OracleDriver");
        	Connection c=DriverManager.getConnection(url, username, password);
        	String query;
            PreparedStatement ps;
            if (inputStream != null) {
        	query="update java121e set emp_name=?,emp_doj=?,emp_sal=?,emp_dept=?, emp_gender=?, emp_address=?,emp_photo=? where emp_id=?";
        	ps=c.prepareStatement(query);
        	ps.setString(8, emp_id);
        	ps.setString(1, emp_name);
        	Date date=Date.valueOf(emp_doj);
        	ps.setDate(2, date);
        	ps.setString(3,emp_sal);
        	ps.setString(4,emp_dept);
        	ps.setString(5,emp_gender);
        	ps.setString(6,emp_address);
        	ps.setBlob(7, inputStream);
            }else {
            	query="update java121e set emp_name=?,emp_doj=?,emp_sal=?,emp_dept=?, emp_gender=?, emp_address=? where emp_id=?";
            	ps=c.prepareStatement(query);
            	ps.setString(7, emp_id);
            	ps.setString(1, emp_name);
            	Date date=Date.valueOf(emp_doj);
            	ps.setDate(2, date);
            	ps.setString(3,emp_sal);
            	ps.setString(4,emp_dept);
            	ps.setString(5,emp_gender);
            	ps.setString(6,emp_address);
            }
        	int rows=ps.executeUpdate();
        	if(rows>0) {
        		out.println("<h1>Data Updated Successfully....</h1>");
        		out.println("<script>");
        		out.println("setTimeout(()=>{window.location='List'},2000);");
        		out.println("</script>");
        	}
        }catch (Exception e) {
            e.printStackTrace();
        }
	}

}
