<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cene</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="adminpage.css">
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
	<ul class="nav navbar-nav">
      <li ><a href="/rentACar/admin/adminpage.jsp">Admin centar</a></li>
      <li><a href="/rentACar/razduziServlet">Razduzi auto</a></li>
      <li class="active"><a href="/rentACar/adminCenovnikServlet">Izmeni cenovnik</a></li>
      <li><a href="/rentACar/uploadServlet">Dodaj fotografije</a></li>
      <li><a href="/rentACar/pregledIznajmljivanjaServlet">Iznajmljivanja</a></li>
    </ul>
    <a href="#"><button class="btn btn-danger navbar-btn">Izvestaji</button></a>

		<a href="<c:url value='/LoginServlet?logout'/>"><button
				class="btn btn-danger navbar-btn pull-right">Log out</button></a>
	</div>
	</nav>
	
	<table  class="table">
			<thead class="thead-inverse">
				<tr>
					<th>Kategorija</th>
					<th>Cena (eur/dan)</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="cena" items="${cene}">
				<tr>
					<td>${cena.imeKategorije }</td>
					<td>${cena.cena }</td>
					<td></td>
				</tr>
				</c:forEach>
			</tbody>
			
			
<!-- 		</table> -->
		
		<form action="/rentACar/adminCenovnikServlet" method="post">
<!-- 		<table class="table"> -->
			<thead class="thead-inverse">
				<tr>
					<th>Kategorija</th>
					<th>Cena</th>
					<th>Akcija</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Odaberite kategoriju:
					<select name="kategorija">
							<c:forEach var="cena" items="${cene}">
								<option value="${cena.idKat }">${cena.imeKategorije } Trenutna cena: ${cena.cena } </option>
							</c:forEach>
					</select></td>
					
					<td class="right"><select name="cena">
							<c:forEach begin="0" end="100" step="5" var="i">
								<option value="${i }">${i }  </option>
							</c:forEach>
					</select></td>
					
<!-- 					<td class="right"><input name="cena" type="text"></td> -->
					<td><input type="submit" value="Promeni"/></td>
				</tr>
			</tbody>
		</table>



	</form>
	
	
</body>
</html>