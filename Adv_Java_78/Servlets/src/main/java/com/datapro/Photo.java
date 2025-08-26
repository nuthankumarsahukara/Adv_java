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
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Photo
 */
@WebServlet("/Photo")
public class Photo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Photo() {
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
		
		int id=Integer.parseInt(request.getParameter("std_id"));
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="nuthan";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection(url, username, password);
			String query="select std_photo from java78s where std_id=?";
			PreparedStatement ps=c.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				Blob blob=rs.getBlob("std_photo");
				byte[] imageByte=blob.getBytes(1, (int)blob.length());
				OutputStream out=response.getOutputStream();
				out.write(imageByte);
				out.close();
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
