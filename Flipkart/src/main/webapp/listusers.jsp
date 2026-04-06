<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.test.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="jakarta.tags.core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ListUsers</title>
</head>
<body>
		<table border="1" width= "50%" align = "center">
					
					<tr>
						<th>ID</th>
						<th>FullName</th>
						<th>UserName</th>
						<th>Password</th>
						<th>Action</th>
					</tr>
					<tbody>
					  <c:forEach var="obj" items="${info}">
						<tr>
							<td>${obj.getId()}</td>
							<td>${obj.getFullname()}</td>
							<td>${obj.getUsername()}</td>
							<td>${obj.getPassword()}</td>
							<td>Delete &nbsp;&nbsp; Edit</td>
						</tr>
					</c:forEach>
					</tbody>
					
				</table>
		
</body>
</html>