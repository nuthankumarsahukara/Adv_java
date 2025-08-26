package com.datapro;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class photo
 */
@WebServlet("/photo")
public class photo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public photo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String std_id=request.getParameter("std_id");
		String url="jdbc:oracle:thin:@localhost:1521:xe";
        String name="system";
        String password="nuthan";
        
        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
        	Connection c=DriverManager.getConnection(url, name, password);
        	String query="select std_photo from java56s where std_id=?";
        	PreparedStatement ps=c.prepareStatement(query);
        	ps.setString(1, std_id);
        	ResultSet rs=ps.executeQuery();
        	if(rs.next()) {
        		Blob blob=rs.getBlob("std_photo");
        		byte[] imagebyte=blob.getBytes(1, (int)blob.length());
        		response.setContentType("image/jpeg");
        		OutputStream out=response.getOutputStream();
        		out.write(imagebyte);
        		out.close();
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
