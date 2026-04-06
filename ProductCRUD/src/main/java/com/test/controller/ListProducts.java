package com.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.test.dao.ProductDaoImpl;
import com.test.model.Product;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/ListProducts")
public class ListProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		ProductDaoImpl pimpl = new ProductDaoImpl();
		
		List<Product> listData = pimpl.listAllProducts();
		
		ServletContext ctx = getServletContext();
		
		ctx.setAttribute("products", listData);
		
		if(listData.size() > 0)
		{
			response.sendRedirect("listproducts.jsp");
		}
		else
		{
			out.println("<font color = 'red' > No Data Please Add here.</font>");
			
			RequestDispatcher rd = request.getRequestDispatcher("createproduct.jsp");
			
			rd.include(request, response);
		}
		
		
	}

}
