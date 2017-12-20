<%@ page import="com.mysql.*"%>
<%@ page import="java.sql.*, java.util.*"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>

<html>
<head>
<link rel="stylesheet" href="index_styles.css">
<link rel="stylesheet" href="image_slider.css">
<link rel="stylesheet" href="register_style.css">
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
</head>


<body>

<div class="tab">
  <button class="tablinks" onclick="openCity(event, 'SignIn')" id="defaultOpen">All Records</button>
  <button class="tablinks" onclick="openCity(event, 'Register')">Search By Customer</button>
</div>

<div id="SignIn" class="tabcontent">
  <h3>View All Rental Records</h3>
    <div class="login">
  	<form action="http://localhost:8080/cyberflixtemp/CyberFlixStaffCustomerSearchServlet" method="post">  
    <input type="submit" value="View All">
    </form>
  </div>
</div>

<div id="Register" class="tabcontent">
  <h3>Search Rental Records by Customer</h3>
  <div class="login">
  	<form action="http://localhost:8080/cyberflixtemp/CyberFlixStaffCustomerSearchServlet" method="get">
    <input type="text" placeholder="Customer Email" name="customer">  
    <input type="submit" value="Search">
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

</body>
</html>