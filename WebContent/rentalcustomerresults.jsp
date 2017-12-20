<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel= "stylesheet" href="index_styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FlixBuster</title>
<div id="head_container">
		<a href="http://localhost:8080/cyberflixtemp/startup.jsp"> <img
			src="http://localhost:8080/cyberflixtemp/images/logo.png"
			alt="FlixBusterLogo">
		</a> <a href="http://localhost:8080/cyberflixtemp/login_Register2.jsp"
			class="sign_in_button">Sign In</a> 
			<i class="material-icons"><a
			href="http://localhost:8080/cyberflixtemp/detailsearch.jsp">search
		</a></i>
	<form action="http://localhost:8080/cyberflixtemp/CyberFlixAddToCartServlet" method="get">
			  <input type="hidden" name="action" value="viewCart" >
		      <input type="submit" value="ViewCart">
    </form>

	</div>
</head>
<body>
<%
    if ((request.getAttribute("rentalInfo") == null)) {
%>

<h1>Customer has no rental records.<br/></h1>
<a href="StaffHonePage.jsp">Search Again</a>
<%} else {
%>
	<h1>Customer Rentals Information</h1>
	<div class="w3-card-4">
		<c:forEach items="${rentalInfo}" var="rental">
			<div class="details">	
				<h4>${rental.toString()}</h4>
			</div>
			<hr>
		</c:forEach>
	</div>
<%
    }
%>

</body>
</html>