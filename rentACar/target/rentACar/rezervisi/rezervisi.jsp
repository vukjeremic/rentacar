<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
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
      <li><a href="/rentACar/vozniParkServlet">Vozni park</a></li>
      <li><a href="/rentACar/cenovnikServlet">Cenovnik</a></li>
      <li  class="active"><a href="/rentACar/rezervisiServlet">Rezervisi</a></li>
    </ul>
    <a href="/rentACar/kontakt/kontakt.jsp"><button class="btn btn-danger navbar-btn">Kontakt</button></a>
    <a href="<c:url value='/LoginServlet?logout'/>"><button class="btn btn-danger navbar-btn pull-right">Log out</button></a>
  </div>
</nav>

<body>

	
	
	<form action="/rentACar/rezervisiServlet" method="post">
	
		<table class="table">
			<tr>
				<td>Odaberite vozilo:</td>
				<td class="right">
					<select name="vozniPark">
						
                        
						<c:forEach var="vp" items="${autalista}">
								<option value="${vp.registracija }">${vp.marka} ${vp.model} ${vp.boja}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>Datum preuzimanja vozila:</td>
				<td class="right">
					<input name="datumPreuzimanja" type="date" value='<fmt:formatDate pattern="yyyy-MM-dd" value="${datumPreuzimanja }"/>'/>
				</td>
			</tr>
			
			<tr><td>Trajanje najma:</td><td class="right"><select name="trajanjeNajma">
							<c:forEach begin="0" end="100" var="i">
								<option value="${i }">${i } dana </option>
							</c:forEach>
					</select></td>
			<tr><td>Ime:</td><td class="right"><input name="ime" type="text"></td></tr>
			<tr><td>Prezime:</td><td class="right"><input name="prezime" type="text"></td></tr>
			<tr><td>JMBG:</td><td class="right"><input name="jmbg" type="text"></td></tr>
			<tr>
				<td>Datum rodjenja:</td>
				<td class="right">
					<input name="datumRodjenja" type="date" value='<fmt:formatDate pattern="yyyy-MM-dd" value="${datumRodjenja }"/>'/>
				</td>
			</tr>
			<tr>
				<td>Odaberite dodatak:</td>
				<td class="right">
					<select name="dodaci"> 
						<c:forEach var="dod" items="${dodacilista}">
								<option value="${dod.idDodatka }">${dod.naziv }</option>
							</c:forEach> 
 					</select>
				</td>
			</tr>
			<tr><td colspan="2"><button class="btn btn-danger navbar-btn pull-right" id="potvrdi"type="submit">Iznajmi</button></td></tr>
		</table>
		</form>
    
	
</body>
</body>
</html>