package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/SyncServlet")
public class SyncServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final long startTime = System.nanoTime();
		
		try
		{
			Thread.sleep(4000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		
		out.println("Work completed time elaspsed : "+(System.nanoTime() - startTime ));
		
		out.flush();

	}

}
