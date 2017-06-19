<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
  
<title>Rent A Car</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="homePage.css">
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <ul class="nav navbar-nav">
      <li class="active"><a href="/rentACar/home/homepage.jsp">O nama</a></li>
      <li><a href="/rentACar/vozniParkServlet">Vozni park</a></li>
      <li><a href="/rentACar/cenovnikServlet">Cenovnik</a></li>
      <li><a href="/rentACar/rezervisiServlet">Rezervisi</a></li>
    </ul>
    <a href="/rentACar/kontakt/kontakt.jsp"><button class="btn btn-danger navbar-btn">Kontakt</button></a>
    <a href="<c:url value='/LoginServlet?logout'/>"><button class="btn btn-danger navbar-btn pull-right">Log out</button></a>
  </div>
</nav>


<center><h1>RENT A CAR Novi Sad</h1></center>
  <div class="container">
    	<div id="carousel">
			<figure><img src="http://images.locanto.ae/1151755364/BEST-DEAL-CAR-RENTAL-RATES-FOR-CORPORATE-AND-INDIVIDUAL-ALL-UAE_8.jpg" alt=""></figure>
			<figure><img src="http://www.telegraph.co.uk/cars/images/2017/03/02/Model-X-main-small_trans_NvBQzQNjv4BqhCNFdBOapuzS78PrL0dcsxhPIljy6d_xfBN0bT7pHSw.jpg" alt=""></figure>
			<figure><img src="http://www.mintmodels.com/images/products/thumb/Cadillac_Fleetwood_75_touring_sedan_1941_600_lq_0001.jpg" alt=""></figure>
			<figure><img src="http://www.telegraph.co.uk/content/dam/cars/2016/02/24/kia-niro-small_trans_NvBQzQNjv4BqG266Z8pvfHsZtPughEOWfA_j_ic_M8nAwbpXhuSQmio.jpg" alt=""></figure>
			<figure><img src="http://www.telegraph.co.uk/cars/images/2016/10/05/Q60-main-small_trans_NvBQzQNjv4BqXVgOtoO9yoYSxPUBYmB83afTflCSJXHglvdovkdyc-4.jpg" alt=""></figure>
			<figure><img src="http://www.mintmodels.com/images/products/thumb/aaa.jpg" alt=""></figure>
			<figure><img src="http://static.ibsrv.net/newsletters/hondatech/dec12/mugen.jpg" alt=""></figure>
			<figure><img src="http://static.wixstatic.com/media/bd75b8_190c942928dc4feeac26efd677b784eb~mv2.jpg_srz_186_116_85_22_0.50_1.20_0.00_jpg_srz" alt=""></figure>
			<figure><img src="http://static.wixstatic.com/media/bd75b8_ff05cacded9d4edaa57e2bcfa4c2f706~mv2.jpg_srz_186_116_85_22_0.50_1.20_0.00_jpg_srz" alt=""></figure>
		</div>
	</div>
	<div class="description">
		<p>Rent a car Novi Sad ima odličan odnos cene i kvaliteta. Mi se nalazimo u Novom Sadu, tačnije na Rotkvariji.
		Sva naša vozila su potpuno ispravna i redovno servisirana, ne morate razmišljati o tome da li je auto ispravan ili ne. Sva vozila su potpuno sigurna i opremljena GPS uređem (opciono), tako da možete biti sasvim sigurni da se nećete izgubiti.</p>
		<p>Rent a car Novi Sad vam nudi da preuzmete i vratite vozilo gde god vama odgovara, bilo to da je aerodrom Nikola Tesla u Beogradu ili negde u Novom Sadu, na vama je samo da nas pozovete da se dogovorimo.
		Ukoliko želite vozilo da iznajmite na duži vremenski period, recimo više meseci rent a car Novi Sad vam nudi posebne cene i pogodnosti, pozovite nas, nećete se pokajati.</p>
	</div>
	
</body>
</html>