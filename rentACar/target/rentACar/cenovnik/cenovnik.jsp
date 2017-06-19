<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cenovnik</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="cenovnik.css">
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    
    <ul class="nav navbar-nav">
      <li><a href="/rentACar/home/homepage.jsp">O nama</a></li>
      <li><a href="/rentACar/vozniParkServlet">Vozni park</a></li>
      <li  class="active"><a href="/rentACar/cenovnikServlet">Cenovnik</a></li>
      <li><a href="/rentACar/rezervisiServlet">Rezervisi</a></li>
    </ul>
    <a href="/rentACar/kontakt/kontakt.jsp"><button class="btn btn-danger navbar-btn">Kontakt</button></a>
    <a href="<c:url value='/LoginServlet?logout'/>"><button class="btn btn-danger navbar-btn pull-right">Log out</button></a>
     <!-- <form action="/rentACar/LoginServlet" method="post">
    <button type= "submit" name="logout" class="btn btn-danger navbar-btn pull-right">Log out</button>
    	  
	</form>-->
	
  </div>
</nav>

		<table  class="table">
			<thead class="thead-inverse">
				<tr>
					<th>Kategorija</th>
					<th>Cena (eur/dan)</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="cena" items="${cene}">
				<tr>
					<td>${cena.imeKategorije }</td>
					<td>${cena.cena }</td>
				</tr>
				</c:forEach>
			</tbody>
			
			
		</table>


<form action="/rentACar/cenovnikServlet" method="get">
<table class="comment"><tr>
<td class="commentbox"><div id="dtext">
	  <h4>Ostavi komentar!</h4>
	  <input name="ime" id="namebox" type="text" maxlength="32" size="20" placeholder="Ime" />
	  <br /><br>
	  <textarea name="komentar" id="txt1" class="textbox" rows="6" placeholder="Tvoj komentar"></textarea>
	</div>
	<input type="submit" id="btn-register" value="Komentarisi">
	</td>
<td class="commentbox1">
	<div id="cmtlist">
	<table class="table">
		<thead class="thead-inverse">
				<tr>
					<th>Ime</th>
					<th>Komentar</th>
				</tr>
			</thead>
		<tbody>
				<c:forEach var="komentar" items="${komentari}">
				
				<tr>
					<td>${komentar.ime }</td>
					<td>${komentar.komentar }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div></td>
</tr></table>
</form>
	
</body>
</html>