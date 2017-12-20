<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel= "styleshee" href="index_styles.css">
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
	<%@page import="java.util.List"%>
	<h1>Movies Matching Your Search</h1>
	<div class="w3-card-4">
		<c:forEach items="${films}" var="film">
		
   	 		<div class="w3-container w3-teal w3-hover-grey w3-hover-text-black">
   	 			<a href="http://localhost:8080/cyberflixtemp/CyberFlixMovieDetailServlet?film=${film.title}">  ${film.title} </a>
   	 		</div>	
   	 		
			<div class="w3-container">
			<c:set var="title" value="${film.title}" />
			  <%@ page import="java.io.File" %>
			  <% Object ttl = pageContext.getAttribute("title");
			  String path = "./images/" + ttl.toString() + ".jpg";
			  path = application.getRealPath(path);
			  File file = new File(path); %>
			  <% if(file.exists()) { %>
			  	<img src="./images/${film.title}.jpg" alt="Poster" class="w3-left w3-margin-right" style="width:120px">
			   <% } else { %>
			  	
			  	<img src="./images/MOVIE POSTER NOT FOUND.jpg" alt="Poster" class="w3-left w3-margin-right" style="width:120px">
			  <% } %>
			
				
				<b> Running Time </b> ${film.length} <br> 
				<b> Year: </b>${film.releaseYear}
				<br> ${film.description} <br>
				
			</div>
			<hr>
		</c:forEach>
	</div>
</body>
</html>