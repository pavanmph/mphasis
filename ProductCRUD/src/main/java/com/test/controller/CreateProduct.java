package com.test.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.test.dao.ProductDaoImpl;
import com.test.model.Product;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/CreateProduct")
public class CreateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		
		String brnd = request.getParameter("brand");
		
		String price = request.getParameter("price");
		
		ProductDaoImpl pimpl = new ProductDaoImpl();
		
		Product obj = new Product();
		
		obj.setP_name(name);
		obj.setP_brand(brnd);
		obj.setP_price(price);
		
		int x = pimpl.saveProduct(obj);
		
		if(x > 0)
		{
			response.sendRedirect("index.jsp");
		}
		else
		{
			out.println("<font color = 'red' > Product Not Added. </font>");
			RequestDispatcher rd = request.getRequestDispatcher("createproduct.jsp");
			rd.include(request, response);
		}
	}

}
