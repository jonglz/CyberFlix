<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	
	<div class="title">
		<h1>Search For Your Movie!</h1>
	</div>
	<div class="details">
		<form action="http://localhost:8080/cyberflixtemp/CyberFlixServlet"
			method="get">
			<label for="film_title"> Title<br>
			</label> <input type="text" id="film_title" name="film_title"> <label
				for="film_title"><br>
			<br> Description<br> </label> <input type="text" id="film_desc"
				name="film_description"> <br>
				<br> Rating <br>
				<select name="rating">
				  <option value= >Any</option>
				  <option value="G">G</option>
				  <option value="PG">PG</option>
				  <option value="PG-13">PG-13</option>
				  <option value="NC-17">NC-17</option>
				  <option value="R">R</option>
				</select>
				<br> Runtime <br>
				<select name="run_time">
				  <option value="0">Any</option>
				  <option value="30">30</option>
				  <option value="60">60</option>
				  <option value="120">120</option>
				  <option value="200">200+</option>
				</select>
			<input type="submit" value="Submit">

		</form>
		<input type="button" onclick="location.href='http://localhost:8080/cyberflixtemp/categSearch.jsp' ;" value = "Category Search" />
		<input type="button" onclick="location.href='http://localhost:8080/cyberflixtemp/alphaSearch.jsp' ;" value = "Alphabetical Search" />
	</div>
</div>
</head>
</html>