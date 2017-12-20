<%@ page import="com.mysql.*"%>
<%@ page import="java.sql.*, java.util.*"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>

<html>
<head>
<link rel="stylesheet" href="index_styles.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
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


</div>
</head>
	<div class="title">
		<h1>View Cart</h1>
	</div>
<body>
  <c:forEach var="film" items="${cart.films}">
    <tr>
    <div class="w3-container w3-teal w3-hover-grey w3-hover-text-black">
   	<a href="http://localhost:8080/cyberflixtemp/CyberFlixMovieDetailServlet?film=${film.title}"> ${film.title} x$1.00 </a>
   	</div>	
    </tr>
  </c:forEach>
  <br> 
  
  
<%
    if ((session.getAttribute("userid") == null) || (session.getAttribute("userid") == "")) {
%>

<h1>You are not logged in<br/></h1>
<h1><a href="login_Register2.jsp">Please Login</a></h1>
<%} else {
%>
<h1>Welcome <%=session.getAttribute("username")%></h1> <br>
  <form action="http://localhost:8080/cyberflixtemp/CyberFlixAddToCartServlet" method="get">
			  <input type="hidden" name="action" value="checkOut">
		      <input type="submit" value="Check Out">
  </form>
<%
    }
%>
  
</body>
</html>