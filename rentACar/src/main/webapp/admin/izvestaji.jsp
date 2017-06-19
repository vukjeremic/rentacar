<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Izvestaji</title>
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
			<li><a href="/rentACar/admin/adminpage.jsp">Admin centar</a></li>
			<li><a href="/rentACar/razduziServlet">Razduzi auto</a></li>
			<li><a href="/rentACar/adminCenovnikServlet">Izmeni cenovnik</a></li>
			<li><a href="/rentACar/uploadServlet">Dodaj fotografije</a></li>
			<li><a href="/rentACar/pregledIznajmljivanjaServlet">Iznajmljivanja</a></li>

		</ul>
		<a href="/rentACar/admin/izvestaji.jsp" class="active""><button
				class="btn btn-danger navbar-btn">Izvestaji</button></a> <a
			href="<c:url value='/LoginServlet?logout'/>"><button
				class="btn btn-danger navbar-btn pull-right">Log out</button></a>
	</div>
	</nav>

	<table class="table">
		<tr>
			<td><img height="256"
					width="256"
					src="https://www.shareicon.net/download/2015/11/19/674595_print_512x512.png" /><br />
				<br /><br/> <br/>
				<a href="/rentACar/admin/report1.jsp"><button class="btn btn-success active btn-lg">Stampaj trenutnu ponudu automobila</button></a></td>
			<form action="/rentACar/klijentServlet" method="post">
			<td><img height="256" width="256"
				src="http://cdn.flaticon.com/png/256/44252.png" /><br />
			<br />
			<input name="jmbgKlijent" type="text" placeholder="Unesite jmbg klijenta" ><br />
			<br /> <input class="btn btn-success active btn-lg"  type="submit"
				value="Podaci o klijentu" /><br/> <br/>${nemaKlijenta }</td>

			</form>
		</tr>
	</table>




</body>
</html>