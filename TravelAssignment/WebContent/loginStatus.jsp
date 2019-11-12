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
<h3>Login Failed</h3><br><br>
<c:out value="${requestScope.err}"></c:out><br>
<a href="login.html"><input type="button" value="try login again"/></a>
</body>
</html>