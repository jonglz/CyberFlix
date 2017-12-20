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
<link rel="stylesheet" href="register_style.css">
<script src="login.js"></script>
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
	<form action="http://localhost:8080/cyberflixtemp/CyberFlixAddToCartServlet" method="get">
			  <input type="hidden" name="action" value="viewCart" >
		      <input type="submit" value="ViewCart">
    </form>

	</div>
</head>

<body>
<div class="tab">
  <button class="tablinks" onclick="openCity(event, 'SignIn')" id="defaultOpen">Sign In</button>
  <button class="tablinks" onclick="openCity(event, 'Register')">Register</button>
</div>

<div id="SignIn" class="tabcontent">
  <h3>Sign In</h3>
    <div class="login">
  	<form action="http://localhost:8080/cyberflixtemp/CyberFlixLoginServlet" method="post">
  
    <input type="text" placeholder="username" name="username">  
    <input type="password" placeholder="password" id="password">  
    <a href="#" class="forgot">forgot password?</a>
    <input type="submit" value="Sign In">
    </form>
  </div>
</div>

<div id="Register" class="tabcontent">
  <h3>Register</h3>
  <div class="login2">
  	<form action="http://localhost:8080/cyberflixtemp/CyberFlixRegisterServlet" method="get">
  
    <input type="text" placeholder="fname" name="fname">  
    <input type="text" placeholder="lname" id="lname" name='lname'>  
    <input type="text" placeholder="email" name="email">  
    <input type="password" placeholder="password" id="password" name='password'>  
    <a href="#" class="forgot">forgot password?</a>
    <input type="submit" value="Sign In">
    </form>
  </div>
</div>

<script>
function openCity(evt, cityName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(cityName).style.display = "block";
    evt.currentTarget.className += " active";
}

// Get the element with id="defaultOpen" and click on it
document.getElementById("defaultOpen").click();
</script>

</body>

</html>