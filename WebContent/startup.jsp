<%@ page import="com.mysql.*"%>
<%@ page import="java.sql.*, java.util.*"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>

<html>
<head>
<body>
<html>
   <div style="display: hidden;">
    <form action="http://localhost:8080/cyberflixtemp/CyberFlixStartServlet" method="get">
        <input type="hidden" name="startup" value="8" />
        <input type="submit" id="formButton" />
    </form>
    <script langua"WebContent/startup.jsp"ge="javascript">
        document.getElementById("formButton").click();
    </script>
</div>
</html>
</body>
</head>
</html>