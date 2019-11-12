<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.training.entity.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>

function viewAllTrips(){
	
	
}
</script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<style>
h3{
text-align:center;
}

</style>
</head>
<body>
<h3> Tours And Travels</h3>
<span id="user">
<c:out value="Welcome ${sessionScope.user.firstName}" /></span><br><br>
<div align="center"><br><br>
<a href="ViewTrip"><input type="button" value="View All trip details" class="btn btn-primary"/></a>


<%
RegisterUser user=(RegisterUser)session.getAttribute("user");

if(user.getTypeOfUser().equalsIgnoreCase("employee")){     

%>
<a href="addTour.html"><input type="button" value="Add trip details" class="btn btn-primary"/></a>
<a href="update.html"><input type="button" value="Update trip details" class="btn btn-primary"/></a>
<%} %>

<a href="ViewTrip"><input type="button" value="Book Tickets" class="btn btn-primary"/></a>


</div>
</body>
</html>
