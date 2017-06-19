<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kontakt</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="kontakt.css">
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    
    <ul class="nav navbar-nav">
      <li><a href="/rentACar/home/homepage.jsp">O nama</a></li>
      <li><a href="/rentACar/vozniParkServlet">Vozni park</a></li>
      <li><a href="/rentACar/cenovnikServlet">Cenovnik</a></li>
      <li><a href="/rentACar/rezervisiServlet">Rezervisi</a></li>
    </ul>
    <a href="/rentACar/kontakt/kontakt.jsp"><button class="btn btn-danger active navbar-btn">Kontakt</button></a>
    <a href="<c:url value='/LoginServlet?logout'/>"><button class="btn btn-danger navbar-btn pull-right">Log out</button></a>
  </div>
</nav>

<div class="container">
	<div class="row-fluid">
        <div class="span8">
        	<iframe width="100%" height="350" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2808.2339031867064!2d19.831610515839984!3d45.26328235484796!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x475b105a0a5758f5%3A0xdbead84f649492c9!2sBerislava+Beri%C4%87a+7%2C+Novi+Sad!5e0!3m2!1sen!2srs!4v1494414587576"></iframe>
    	</div>
    	
      	<div class="span4">
    		<h2>Rent a car Novi Sad</h2>
    		<address>
    			<strong>Rotkvarija</strong><br>
    			Berislava Berica 7<br>
    			Srbija<br>
    			<abbr title="Phone">P:</abbr> 01234 567 890<br>
    			<a href="mailto:rentacarnovisad@rentacarnovisad.ns">Kontaktirajte nas emailom</a>
    		</address>
    	</div>
    </div>
</div>
</body>
</html>