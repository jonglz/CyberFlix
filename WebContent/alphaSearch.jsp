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
		<h1>Alphabeticall Search</h1>
	</div>
	<div id="page-content">
		<form action="http://localhost:8080/cyberflixtemp/CyberFlixAlphaSearchSevlet"
			method="get">
			<label for="film_category"> Alphabetical<br>
			</label> 
				<select name="alpha">
				  <option value="a">A</option>
				  <option value="b">B</option>
				  <option value="c">C</option>
				  <option value="d">D</option>
				  <option value="e">E</option>
				  <option value="f">F</option>
				  <option value="g">G</option>
				  <option value="h">H</option>
				  <option value="i">I</option>
				  <option value="j">J</option>
				  <option value="k">K</option>
				  <option value="l">L</option>
				  <option value="m">M</option>
				  <option value="n">N</option>
				  <option value="o">O</option>
				  <option value="p">P</option>
				  <option value="q">Q</option>
				  <option value="r">R</option>
				  <option value="s">S</option>
				  <option value="t">T</option>
				  <option value="u">U</option>
				  <option value="v">V</option>
				  <option value="w">W</option>
				  <option value="x">X</option>
				  <option value="y">Y</option>
				  <option value="z">Z</option>
				  				  				  			
				</select>
			<input type="submit" value="Submit">

		</form>
		<input type="button" onclick="location.href='http://localhost:8080/cyberflixtemp/detailsearch.jsp' ;" value = "Detail Search" />
		<input type="button" onclick="location.href='http://localhost:8080/cyberflixtemp/categSearch.jsp' ;" value = "Category Search" />
	</div>
</div>
</head>
</html>