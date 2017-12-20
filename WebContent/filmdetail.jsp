<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.List"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	<div class="title">
		<h1>Movie Details</h1>
	</div>
<div class="detail_page">
		<a
			href="http://localhost:8080/CyberFlix_FS/CyberFlixMovieDetailServlet?film_title=${film.title}">
			<img
			src="http://localhost:8080/CyberFlix_FS/images/${film.title}${'.png'}"
			alt="${film.title}" />
		</a>
		<div class="output">
			<p>${film.title}</p>
		</div>
		<div class="output">
			<b>Year: </b> ${film.releaseYear}
		</div>
		<div class="output">
			<b>Rating: </b> ${film.rating}
		</div>
		<div class="output">
			<b>Running Time: </b> ${film.length}
		</div>
		<br>
		<div class="output">${film.description}</div>
		<br>
		<div class="output">
			<c:forEach var="actor" items="${film.actors}">
		${actor.firstName} ${actor.lastName}, 
		</c:forEach>
		</div>
	</div>

	<br>
	<br>
	<br>
	
</body>
</head>
</html>