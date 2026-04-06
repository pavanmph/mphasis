package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("fname");
		
		String usr = request.getParameter("user");
		
		String pas = request.getParameter("pwd");
		
		Customer cst = new Customer();
		
		cst.setFullName(name);
		cst.setUserName(usr);
		cst.setPassword(pas);
		
		String sql = " insert into customer values ('"+cst.getFullName()+"', '"+cst.getUserName()+"', '"+cst.getPassword()+"') ";
		
		try
		{
			Connection con = DBConnect.getCon();
			
			Statement stmt = con.createStatement();
			
			int dt = stmt.executeUpdate(sql);
			
			if(dt > 0)
			{
				response.sendRedirect("login.html");
				
			}
			else
			{
				out.println("<font color = 'red'><h3 align = 'center'> Registration failed.</h3></font>");
				
				RequestDispatcher rd = 
						request.getRequestDispatcher("register.html");
				rd.include(request, response);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
