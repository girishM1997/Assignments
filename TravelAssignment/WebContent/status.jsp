<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:out value="${details}"></c:out>
<br>
<c:out value="${totalCost}"></c:out>
<br>
<a href="travelHome.jsp"><input type="button" value="Home"/></a>
</body>
</html>