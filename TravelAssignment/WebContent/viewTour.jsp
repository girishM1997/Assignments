<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.training.entity.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
table{
border:1px solid black;
align:center;
}

h3{
text-align:center;
}

</style>
</head>
<body>
<h3>Tours And Travels</h3>
<c:out value="Welcome ${sessionScope.user.firstName}" /><br><br>
<div style="text-align:center;">
<h3>View Trip Details</h3><br>
<form action="SearchTour" method="post">
<label >Search By TourName</label>

<select name="tourName">
  <option value="Bangalore-Mysore">Bangalore-Mysore</option>
  <option value="Bangalore-Mangalore">Bangalore-Mangalore</option>
  <option value="Kashmir-Kanyakumari">Kashmir-Kanyakumari</option>
  <option value="Kashmir-WestBengal">Kashmir-WestBengal</option>
</select>
<input type="submit" value="Search">
<a href="ViewTrip"><input type="button" value="View All trip details"/></a>
<a href="travelHome.jsp"><input type="button" value="Home"/></a>
</form>



<br><br>
<table border="1" align="center" >
<caption>Trip Details</caption>
	<tr>
		<th>Code</th>
		<th>Tour Name</th>
		<th>Start Date</th>
		<th>End Date</th>
		<th>Places Covered</th>
		<th>Number of Days</th>
		<th>Cost</th>
		</tr>
		<c:forEach var="eachtour" items="${requestScope.tourList}">
		<tr>
			<td><c:out value="${eachtour.code}" /></td>
			<td><c:out value="${eachtour.tourName}" /></td>
			<td><c:out value="${eachtour.startDate}" /></td>
			<td><c:out value="${eachtour.endDate}" /></td>
			<td><c:out value="${eachtour.places}" /></td>
			<td><c:out value="${eachtour.numberOfDays}" /></td>
			<td><c:out value="${eachtour.cost}" /></td>
		</tr>
		</c:forEach>
</table><br><br>
<h3>Book Tickets</h3><br>

<form action="BookTicket" method="post">
<label>Code:</label>
<input type="number" name="code" />
<label>Number Of Tickets:</label>
<input type="number" name="numberOfTickets" />
<input type="submit" value="BookTicket"/>
</form>
</div>
</body>
</html>