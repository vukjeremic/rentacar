<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login to rent a car Novi Sad</title>
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="login.css">
</head>
<body>
	<!--Pulling Awesome Font -->

	<form method="post" action="/rentACar/LoginServlet">
		<div class="container">
			<div class="row">
				<div class="col-md-offset-5 col-md-3">
					<div class="form-login">
						<h4>Login to rent a car Novi Sad.</h4>
						<input name="username" type="text" id="userName"
							class="form-control input-sm chat-input" placeholder="username" />
						</br> <input name="pass" type="password" id="userPassword"
							class="form-control input-sm chat-input" placeholder="password" />
						</br>
						<div class="wrapper">
							<span class="group-btn"> <input type="submit"
								value="Prijavi se"> <a href="/rentACar/registerServlet"><button
										name="register" id="btn-register" type="button"
										class="btn btn-info btn-block">
										<i class="icon-hand-right"></i> &nbsp Register
									</button></a>
							</span>
						</div>
					</div>
				</div>
			</div>
		</div>

	</form>



</body>
</html>