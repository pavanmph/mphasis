<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="jakarta.tags.core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list products</title>
</head>
<body>
		<h1 align="center">List of All Products</h1>
		
		<table border="1" width = "50%" align="center">
		
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Brand</th>
				<th>Price</th>
				<th>Actions</th>
			</tr>
			<tbody align="center">
				
				<c:forEach var = "data" items="${products}">
					
					<tr>
						<td>${data.getId()}</td>
						<td>${data.getP_name()}</td>
						<td>${data.getP_brand()}</td>
						<td>${data.getP_price()}</td>
						<td>Delete &nbsp;&nbsp; Edit</td>
					</tr>
				</c:forEach>
				
			</tbody>
		
		</table>
		<br>
		
		<h2 align="center"><a href = "createproduct.jsp"> Add Product Here </a></h2>
		
</body>
</html>