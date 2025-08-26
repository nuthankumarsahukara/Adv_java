package com.datapro;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Insert() {
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
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		if(session==null || session.getAttribute("email")==null) {		
		response.sendRedirect("Login.html");
		return;
	}
		String name=request.getParameter("name");
		String fname=request.getParameter("fname");
		String mname=request.getParameter("mname");
		String gender=request.getParameter("gender");
		String id=request.getParameter("id");
		
		
		System.out.println(name);
		System.out.println(fname);
		System.out.println(mname);
		System.out.println(gender);
		System.out.println(id);
		try {
		String url="jdbc:oracle:thin:@localhost:1521/xe";
		String username="system";
		String password="nuthan";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver class found");
		Connection con=DriverManager.getConnection(url,username,password);
		System.out.println("Database connected");
		String query="insert into servlets values(?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, name);
		ps.setString(2, fname);
		ps.setString(3, mname);
		ps.setString(4, gender);
		ps.setString(5, id);
		ps.execute();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>Thank You Data is Submitted Successfully ....</h1>");
		out.println("<script>");
		out.println("setTimeout(()=>{window.location.href='Table'},5000)");
		out.println("</script>");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
