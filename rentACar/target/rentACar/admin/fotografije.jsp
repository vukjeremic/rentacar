<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fotografije</title>
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
      <li ><a href="/rentACar/razduziServlet">Razduzi auto</a></li>
      <li><a href="/rentACar/adminCenovnikServlet">Izmeni cenovnik</a></li>
      <li class="active"><a href="/rentACar/uploadServlet">Dodaj fotografije</a></li>
      <li><a href="/rentACar/pregledIznajmljivanjaServlet">Iznajmljivanja</a></li>
    </ul>
    <a href="#"><button class="btn btn-danger navbar-btn">Izvestaji</button></a>

		<a href="<c:url value='/LoginServlet?logout'/>"><button
				class="btn btn-danger navbar-btn pull-right">Log out</button></a>
	</div>
	</nav>
	
	 <center>
        <h1>Upload fotografija u bazu</h1>
        <form method="post" action="/rentACar/uploadServlet" enctype="multipart/form-data">
            <table border="0">
                
                <tr>
                    <td>Odaberite fotografiju: </td>
                    <td><input type="file" name="photo" size="50"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Save">
                    </td>
                </tr>
            </table>
        </form>
        <a href="/rentACar/admin/pregledFotografija.jsp"><button class="btn btn-danger navbar-btn">Pregled fotografija</button></a>
    </center>
	
	
</body>
</html>