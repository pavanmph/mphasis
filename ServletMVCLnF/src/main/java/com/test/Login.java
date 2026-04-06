package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String usr = request.getParameter("user");
		
		String pas = request.getParameter("pwd");
		
		Customer cst = new Customer();
		
		String sql = "select username, password from customer where username = '"+usr+"' and password = '"+pas+"' ";
		
		try {
			
			Connection con = DBConnect.getCon();
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				cst.setUserName(rs.getString(1));
				cst.setPassword(rs.getString(2));
			}
			
			if(usr.equals(cst.getUserName()) && pas.equals(cst.getPassword()))
			{
				response.sendRedirect("https://gmstedu.com/");
			}
			else
			{
				out.println("<font color = 'red'><h3 align = 'center' >invalid credentials</h3></font>");
				
				RequestDispatcher rd = 
						request.getRequestDispatcher("login.html");
				rd.include(request, response);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
