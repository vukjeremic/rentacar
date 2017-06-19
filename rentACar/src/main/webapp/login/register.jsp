<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="login.css">

</head>
<body>
	<form method="post" action="/rentACar/registerServlet">
		<div class="center">
			<div id="fullscreen_bg" class="fullscreen_bg" />
<!-- 			<div class="container" id="123"> -->
				
				<div id="signupbox" style="margin-top: 50px"
					class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
					<div class="form-login">
<!-- 					<div class="panel panel-info"> -->

						<div class="panel-body">
							<form id="signupform" class="form-horizontal" role="form">

<br/>


								<div class="form-group">
									<label for="email" class="col-md-3 control-label">Email</label>
									<div class="col-md-9">
										<input name="username" type="email" id="userName"
												class="form-control input-sm chat-input"
												placeholder="Email adress" />


									</div>
								</div>


								<div class="form-group">
									<label for="password" class="col-md-3 control-label">Password</label>
									<div class="col-md-9">
										<input name="pass" type="password" id="userPassword"
											class="form-control input-sm chat-input"
											placeholder="password" />
									</div>
								
							</div>

								<br>

								<div class="form-group">
									<!-- Button -->
									<div class="col-md-offset-3 col-md-9">
										<br />
										<input class="btn btn-info btn-block" type="submit"
										id="btn-register" value="Register">
										<br /><a href="/rentACar/LoginServlet"><button
											onclick="test()" name="register" id="btn-register"
											type="button" class="btn btn-info btn-block">
												<i class="icon-hand-right"></i>Login page
											</button></a>
									</div>

								</div>




							
	</form>
						</div>
<!-- 					</div> -->
	</div>
					</br>
					<center><font size="5" color="white">${por }</font></center>
				</div>
<!-- 			</div> -->
		</div>

		<center>
			
		</center>
	</form>
	

	<script>
		email = document.getElementById("userName").value;
		email = document.getElementById("userPassword").value;
	</script>

</body>
</html>