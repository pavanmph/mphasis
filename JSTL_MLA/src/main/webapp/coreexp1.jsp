<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import="java.util.List"%>
    <%@page import="java.util.Arrays"%>
    
    <%@ taglib uri = "jakarta.tags.core" prefix ="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL-CORE</title>
</head>
<body>

<h1>JSTL Core Tags</h1>

<c:forEach var="a" begin="1" end="10">
<c:out value="${a}"></c:out><br>

</c:forEach>
<%
	List<String> listNames = Arrays.asList("Rohit", "Virat", "SKY", "HP", "Axar");
application.setAttribute("names",listNames);
%>

<c:forEach var="data" items="$(names)">
<c:out value="$(data)"></c:out><br>
</c:forEach>
<c:set var="age" value="${18}"></c:set>
<c:out value="$(age))"></c:out>
<%-- <c:remove var="age"/> --%>


<c:choose>
<c:when test="${ age == 18 }">
<c:out value ="Just Eligible"></c:out>
</c:when>
<c:when test="${age > 18 }">
<c:out value ="most Eligible"></c:out>
</c:when>
<c:otherwise>
<c:out value="not eligible for voting"></c:out>
</c:otherwise>
</c:choose>




</body>
</html>