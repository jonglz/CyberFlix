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
</head>
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
	<body>
	
	<%@page import="java.util.List"%>
	<div id="text">
		<c:forEach items="${films}" var="film">
   	 		<div class="w3-container w3-teal">
   	 			<h1>${film.title} </h1>
   	 		</div>	
	<div class="details">
			<c:set var="title" value="${film.title}" />
			  <%@ page import="java.io.File" %>
			  <% Object ttl = pageContext.getAttribute("title");
			  String path = "./images/" + ttl.toString() + ".png";
			  path = application.getRealPath(path);
			  File file = new File(path); %>
			  <% if(file.exists()) { %>
			  	<img src="./images/${film.title}.png" alt="Poster" style="width:200px">
			   <% } else { %>
			  	
			  	<img src="./images/MOVIE POSTER NOT FOUND.jpg" alt="Poster" style="width:200px">
			  <% } %>
				<b> Running Time </b> ${film.length} <br> 
				<b> Year: </b> ${film.releaseYear} <br> 
				<b> Rating: </b> ${film.rating} <br> 
				<b> Description </b>
				<br> ${film.description} <br>

				<b> Actors </b> <br>
				<c:forEach var="actor" items="${film.actors}">
        			<tr>
        			  <td>${actor.firstName} ${actor.lastName}, </td>
      			  </tr>
      			</c:forEach>
			
			<form action="http://localhost:8080/cyberflixtemp/CyberFlixAddToCartServlet" method="get">
			  <input type="hidden" name="action" value="addToCart">
			  <input type="hidden" name="film" value="${film.title}">
		      <input type="submit" value="Add To Cart">
		    </form>
		</c:forEach>
		
	</div>
</body>
</div>
</div>

</html>



