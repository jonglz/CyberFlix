<%@ page import="com.mysql.*"%>
<%@ page import="java.sql.*, java.util.*"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>

<html>
<head>
<link rel="stylesheet" href="index_styles.css">

<meta name="viewport" content="width=device-width, initial-scale=1">
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
		</a> 
		
		
<%
    if ((session.getAttribute("userid") == null) || (session.getAttribute("userid") == "")) {
%>
<a href="http://localhost:8080/cyberflixtemp/login_Register2.jsp"
class="sign_in_button">Sign In</a> 
<%} else {
%>
<a href="http://localhost:8080/cyberflixtemp/logout.jsp"
class="sign_in_button">Sign Out</a> 
<%
    }
%>
			
			<i class="material-icons"><a
			href="http://localhost:8080/cyberflixtemp/detailsearch.jsp">search
		</a></i>
		<div class="viewcart_Button">
	<form action="http://localhost:8080/cyberflixtemp/CyberFlixAddToCartServlet" method="get">
			  <input type="hidden" name="action" value="viewCart">
		      <input type="submit" value="ViewCart">
    </form>
    </div>

	</div>
	
</head>


<body>
	<div class="title">
		<h1>New Movie Releases</h1>
	</div>

	<c:forEach items="${films}" var="film">
		<div id="card">
			<c:set var="title" value="${film.title}" />
			<%@ page import="java.io.File"%>
			<% Object ttl = pageContext.getAttribute("title");
			  String path = "./images/" + ttl.toString() + ".png";
			  path = application.getRealPath(path);
			  File file = new File(path); %>
			<% if(file.exists()) { %>
			<a
				href="http://localhost:8080/cyberflixtemp/CyberFlixMovieDetailServlet?film=${film.title}">
				<img src="./images/${film.title}.png" class="splashimage">
			</a>
			<div class="overlay">
				<div class="text">${film.title}</div>
			</div>
			<% } else { %>
			<img src="./images/MOVIE POSTER NOT FOUND.jpg" class="splashimage">
			<% } %>
		</div>

	</c:forEach>
</body>


<body>
<footer>
  <input type="button" onclick="location.href='http://localhost:8080/cyberflixtemp/CustomerSignIn.jsp' ;" value = "Staff Sign In" />
  <br>
  <p>Posted by: JoMiBi group</p>
</footer>
</body>
</html>