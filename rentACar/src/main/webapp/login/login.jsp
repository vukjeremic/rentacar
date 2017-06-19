<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<META Http-Equiv="Cache-Control" Content="no-cache" />
<META Http-Equiv="Pragma" Content="no-cache" />
<META Http-Equiv="Expires" Content="0" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login to rent a car Novi Sad</title>
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="login.css">
</head>
<body>
	<!--Pulling Awesome Font -->
	<br/><br/><br/>
			<form method="post" action="/rentACar/LoginServlet">
<!-- 		<div class="container" id="123"> -->
<%-- <center> --%>
<!-- 			<div class="row"> -->
				<div class="col-md-offset-4 col-md-4">
					<div class="form-login">
						<h4>Login to rent a car Novi Sad.</h4>
						<input name="username" type="text" id="userName"
							class="form-control input-sm chat-input" placeholder="username" />
						</br> <input name="pass" type="password" id="userPassword"
							class="form-control input-sm chat-input" placeholder="password" />
						</br>
						<div class="wrapper">
							<span> <input class="btn btn-info btn-block" type="submit"
								value="Prijavi se"> <a href="/rentACar/registerServlet"><br />
								<button name="register" id="btn-register" type="button"
										class="btn btn-info btn-block">
										<i class="icon-hand-right"></i> &nbsp Register
									</button></a>
							</span>
						</div>
					</div>
				</div>
<!-- 			</div> -->
<%-- 			</center> --%>
<!-- 		</div> -->

	</form>
	



</body>
</html>