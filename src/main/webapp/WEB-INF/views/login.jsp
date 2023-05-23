<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Loggy</title>

<%@include file="partials/header-links.jsp"%>

</head>
<body style="min-height: 100vh;" class="d-flex  justify-content-center align-items-center">

	<main class="login-page w-100">
		<form action="login" method="post" class="col-lg-5 border m-auto py-4">
			<div class="form-group">
				<label for="email">Email address:</label> 
				<input type="email" name="email"
					class="form-control" placeholder="Enter email" id="email">
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password"
					class="form-control" placeholder="Enter password" id="pwd">
			</div>
			<div class="form-group form-check">
				<label class="form-check-label"> 
				<input
					name="password"
					class="form-check-input" type="checkbox"> Remember me
				</label>
			</div>
			<button type="submit" class="btn btn-primary">Login</button>
		</form>
	</main>



</body>
</html>