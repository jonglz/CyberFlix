<%@ page import="com.mysql.*"%>
<%@ page import="java.sql.*, java.util.*"%>
<%@ page import="edu.txstate.cyberflix.data.db.JoMiBi.FilmDAO"%>
<%@ page import="edu.txstate.internet.cyberflix.data.film.Film"%>
<%@ page import="edu.txstate.internet.cyberflix.data.DataSource"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>



     <sql:setDataSource dataSource="jdbc/sakila" />

<html>
<head>
<link rel="stylesheet" href="index_styles.css">
<link rel="stylesheet" href="login_style.css">
<script src="login.js"></script>
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
	</div>
  <div class="login">
  	<form action="http://localhost:8080/cyberflixtemp/CyberFlixStaffLoginServlet" method="get">
  
    <input type="text" placeholder="username" name="username">  
  <input type="password" placeholder="password" id="password">  
  <a href="#" class="forgot">forgot password?</a>
  <input type="submit" value="Sign In">
</div>
  </form>



</body>
</html>