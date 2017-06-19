<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pregled iznajmljivanja</title>
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
      <li><a href="/rentACar/adminCenovnikServlet">Izmeni cenovnik</a></li>
      <li><a href="/rentACar/uploadServlet">Dodaj fotografije</a></li>
      <li   class="active"><a href="/rentACar/pregledIznajmljivanjaServlet">Iznajmljivanja</a></li>
      
    </ul>
    <a href="#"><button class="btn btn-danger navbar-btn">Izvestaji</button></a>

		<a href="<c:url value='/LoginServlet?logout'/>"><button
				class="btn btn-danger navbar-btn pull-right">Log out</button></a>
	</div>
	</nav>
	<form action="/rentACar/pregledIznajmljivanjaServlet" method="get">

		<p>Pregled iznajmljivanja:</p>


		<table class="table">
			<thead class="thead-inverse">
				<tr>
					<th>idIznajmljivanja</th>
					<th>Preuzeto</th>
					<th>Trajanje</th>
					<th>Registracija</th>
					<th>Dodatak</th>
					<th>JMBG</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="iz" items="${iznjamljivanjeLista}">
					<tr>
						<td>${iz.idIznajmljivanja }</td>
						<td>${iz.datumPreuzimanja }</td>
						<td>${iz.trajanjeNajma }</td>
						<td>${iz.auto.registracija }</td>
						<td>${iz.dodaci.naziv }</td>
						<td>${iz.klijent.jmbg }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</form>
<form action="/rentACar/pregledIznajmljivanjaServlet" method="post">
		<table class="table">
			<thead class="thead-inverse">
				<tr>
					<th>Opcija</th>
					<th>Izbor</th>
					<th>Aktivnost</th>


				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Odaberite iznajmljivanje:</td>
					<td class="right"><select name="idIznajmljivanja">
							<c:forEach var="iz" items="${iznjamljivanjeLista}">
								<option value="${iz.idIznajmljivanja }">${iz.klijent.jmbg} ${iz.auto.registracija} Preuzet: ${iz.datumPreuzimanja}</option>
							</c:forEach>
					</select></td>
					<td><input type="submit" value="Izracunaj"/></td>
				</tr>
				<div id="demo">
				<tr hidden><td colspan="3" id="demo1">${podaciIznajmljivanja }</td></tr>
				<tr><td colspan="3" id="demo2">${cenaIspis }</td></tr>
				<tr hidden><td colspan="3" id="demo3">${uplataIspis }</td><</tr>
				</div>
				<tr><td colspan="3" ><button onclick="PrintElem()">Stampaj slip</button></td></tr>
			</tbody>
		</table>

		
	</form>

<script>
function PrintElem()
{
// 	var blabla=document.getElementById("demo");
// 	alert(blabla);
    var mywindow = window.open('', 'PRINT', 'height=400,width=600');

    
    mywindow.document.write('<html><head><title>' + "Rent a car Novi Sad"  + '</title>');
    mywindow.document.write('</head><body >');
    mywindow.document.write('<h1><center>' + document.title  + '</center></h1>');
    mywindow.document.write("<center>");
    
    mywindow.document.write("Slip sa detaljima potrebnim za uplatu </br>");
    mywindow.document.write("</center>");
    mywindow.document.write("</br></br></br></br>");
    mywindow.document.write("<center>");
    mywindow.document.write(document.getElementById("demo1").innerHTML);
    mywindow.document.write("</center>");
    mywindow.document.write("</br>");
    mywindow.document.write("<center>");
    mywindow.document.write(document.getElementById("demo2").innerHTML);
    mywindow.document.write("</center>");
    mywindow.document.write("</br>");
    mywindow.document.write("<center>");
    mywindow.document.write(document.getElementById("demo3").innerHTML);
    mywindow.document.write("</center>");
    mywindow.document.write("</br>");
    mywindow.document.write("<p align=\"right\">");
    mywindow.document.write("Potvrda stampana: "+Date());
    mywindow.document.write("</p>");
    
    mywindow.document.write('</body></html>');
    mywindow.document.close(); // necessary for IE >= 10
    mywindow.focus(); // necessary for IE >= 10*/

    mywindow.print();
    mywindow.close();

    return true;
}
</script>
</body>
</html>