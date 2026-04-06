package com.test;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String usr = request.getParameter("user");
		
		String pas = request.getParameter("pwd");
		
		if(usr.equals("admin")&& pas.equals("java")) {
			//RequestDispatcher rd = request.getRequestDispatcher("home.html");
			
			//rd.forward(request, response);
			response.sendRedirect("https://gmst.in/");
			
		}
		else {
			out.println("<font color='red'>invalid credentials</font>");
			
			RequestDispatcher rd = request.getRequestDispatcher("Login.html");
			rd.include(request, response);
			
			
		}
		
	}

}
