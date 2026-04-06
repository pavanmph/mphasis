<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>product</title>
</head>
<body>
		<h1 align="center">Product Form &nbsp; &nbsp; <a href = "ListProducts">list products</a></h1> 
		
	<center>
		
		<form action="CreateProduct" method="post">
		
			Enter ProductName : <input type = "text" name = "name"><br><br>
			Enter ProductBrand : <input type = "text" name = "brand"><br><br>
			Enter ProductPrice : <input type = "text" name = "price"><br><br>
			
				<input type = "submit" value="login">
		
		</form>
	</center>	
</body>
</html>