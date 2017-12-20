<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
		<h2>(By Category)</h2>
	</div>
	<div id="page-content">
		<form action="http://localhost:8080/cyberflixtemp/CyberFlixCategSearchSevlet"
			method="get">
			<label for="film_category"> Category<br>
			</label> 
				<select name="category">
				  <option value="ACTION">ACTION</option>
				  <option value="ANIMATION">ANIMATION</option>
				  <option value="CHILDREN">CHILDREN</option>
				  <option value="CLASSICS">CLASSICS</option>
				  <option value="COMEDY">COMEDY</option>
				  <option value="DOCUMENTARY">DOCUMENTARY</option>
				  <option value="DRAMA">DRAMA</option>
				  <option value="FAMILY">FAMILY</option>
				  <option value="FOREIGN">FOREIGH</option>
				  <option value="GAMES">GAMES</option>
				  <option value="HORROR">HORROR</option>
				  <option value="MUSIC">MUSIC</option>
				  <option value="NEW">NEW</option>
				  <option value="SCI_FI">SCI_FI</option>
				  <option value="SPORTS">SPORTS</option>
				  <option value="TRAVEL">TRAVEL</option>
				</select>
			<input type="submit" value="Submit">

		</form>
		<input type="button" onclick="location.href='http://localhost:8080/cyberflixtemp/detailsearch.jsp' ;" value = "Detail Search" />
		<input type="button" onclick="location.href='http://localhost:8080/cyberflixtemp/alphaSearch.jsp' ;" value = "Alphabetical Search" />
	</div>
</div>
</head>
</html>