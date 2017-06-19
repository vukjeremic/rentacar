<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rezervisi</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="rezervisi.css">
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    
    <ul class="nav navbar-nav">
      <li><a href="/rentACar/home/homepage.jsp">O nama</a></li>
      <li><a href="/rentACar/vozniPark/vozniPark.jsp">Vozni park</a></li>
      <li><a href="/rentACar/cenovnik/cenovnik.jsp">Cenovnik</a></li>
      <li  class="active"><a href="/rentACar/rezervisi/Rezervisi.jsp">Rezervisi</a></li>
    </ul>
    <a href="/rentACar/kontakt/kontakt.jsp"><button class="btn btn-danger navbar-btn">Kontakt</button></a>
    <button class="btn btn-danger navbar-btn pull-right">Log out</button>
  </div>
</nav>
</body>
</html>