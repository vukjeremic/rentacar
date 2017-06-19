<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vozni park</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="vozniPark.css">
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    
    <ul class="nav navbar-nav">
      <li><a href="/rentACar/home/homepage.jsp">O nama</a></li>
      <li  class="active"><a href="/rentACar/vozniParkServlet">Vozni park</a></li>
      <li><a href="/rentACar/cenovnikServlet">Cenovnik</a></li>
      <li><a href="/rentACar/rezervisiServlet">Rezervisi</a></li>
    </ul>
    <a href="/rentACar/kontakt/kontakt.jsp"><button class="btn btn-danger navbar-btn">Kontakt</button></a>
    <a href="<c:url value='/LoginServlet?logout'/>"><button class="btn btn-danger navbar-btn pull-right">Log out</button></a>
  </div>
</nav>
	
	<form action="/rentACar/vozniParkServlet" method="get">
		<table  class="table">
			<thead class="thead-inverse">
				<tr>
					<th>Marka</th>
					<th>Model</th>
					<th>Gorivo</th>
					<th>Boja</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="auto" items="${auta}">
				<tr>
					<td>${auto.marka }</td>
					<td>${auto.model }</td>
					<td>${auto.gorivo }</td>
					<td>${auto.boja }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
	



	
	
</body>
</html>