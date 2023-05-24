
<%@page import="loggy.entities.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>

<%
	User loggedUser = null; 
	if(session.getAttribute("user") != null){
		loggedUser = (User) session.getAttribute("user");
	}
%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home</title>

	<%@include file="partials/header-links.jsp"%>

</head>

<body class="row">

		<%
			if(loggedUser != null){
			%>
				<%@include file="partials/left_sidenav_after_log.jsp"%>
			<%				
			}else{
			%>
				<%@include file="partials/left_sidenav_before_log.jsp"%>
			<%
			}
		%>
	

	<main class="offset-lg-3 col-lg-6">
		<div class="body-nav">Explore</div>
		
			<!-- Write blog -->
		<%
			if(loggedUser != null){
			%>
				<%@include file="partials/writeBlog.jsp"%>
			<%				
			}
		%>
		


		<div class="all-contents">
			<div class="content-box">
				<div class="content-header-info d-flex align-items-center">
					<!-- user image -->
					<img class="content-owner-image p-1" src="resources/image/user.jpg"
						alt="user">

					<!-- user info -->
					<div class="">
						<span class="font-weight-bold pl-3">Shubrato Debnath.</span> <br>
						<span class="text-muted pl-3">5:10 pm &nbsp; 31 May, 2020</span>
					</div>
				</div>
				<!-- content text -->
				<div class="content-text my-3">
					<h4>Serenity at Dusk: A Golden Sea's Gentle Embrace</h4>
					<p>The sun sets, casting a golden hue upon the tranquil sea, as
						waves gently lap against the shore in a soothing rhythm.The sun
						sets, casting a golden hue upon the tranquil sea, as waves gently
						lap against the shore in a soothing rhythm.</p>
				</div>
				<!-- content-multimedia -->
				<div class="content-multimedia">
					<img class="card-img" src="resources/image/img1.jpg" alt="POST">
				</div>
				<!-- content interaction -->
				<div class="content-interaction">
					<button>
						<i class="fa-regular fa-heart p-1"></i> Love
					</button>
					<a href=""><i class="fa-sharp fa-regular fa-comment p-1"></i>
						Comment</a>
					<button>Share</button>
				</div>
			</div>
			<div class="content-box">
				<div class="content-header-info d-flex align-items-center">
					<!-- user image -->
					<img class="content-owner-image p-1" src="resources/image/user.jpg"
						alt="user">

					<!-- user info -->
					<div class="">
						<span class="font-weight-bold pl-3">Shubrato Debnath.</span> <br>
						<span class="text-muted pl-3">5:10 pm &nbsp; 31 May, 2020</span>
					</div>
				</div>
				<!-- content text -->
				<div class="content-text my-3">Lorem ipsum dolor sit amet
					consectetur adipisicing elit. Obcaecati illo consequatur quis
					quibusdam. Suscipit quasi blanditiis fugiat nam nostrum! Suscipit
					dicta quae autem adipisci repellendus natus dolor delectus
					consectetur beatae facilis culpa, illo quidem quis quas aperiam
					eligendi? Beatae minus ducimus ullam maiores nisi odit eveniet,
					totam velit blanditiis nostrum?</div>
				<!-- content-multimedia -->
				<div class="content-multimedia">
					<img class="card-img" src="resources/image/img1.jpg" alt="POST">
				</div>
				<!-- content interaction -->
				<div class="content-interaction">
					<button>
						<i class="fa-regular fa-heart p-1"></i> Love
					</button>
					<a href=""><i class="fa-sharp fa-regular fa-comment p-1"></i>
						Comment</a>
					<button>Share</button>
				</div>
			</div>

		</div>

		</div>
	</main>


	<!-- Right Side Nav -->
		<%
			if(loggedUser != null){
			%>
				<%@include file="partials/rightside_after_log.jsp"%>
			<%				
			}else{
			%>
				<%@include file="partials/rightside_before_log.jsp"%>
			<%
			}
		%>

	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>