<%@page import="loggy.entities.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%

	
	User visitedUser = (User) request.getAttribute("visitedUser");	
	User loggedUser = null; 
	if(session.getAttribute("user") != null){
		loggedUser = (User) session.getAttribute("user");
	}
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><%=visitedUser.getName() %></title>

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
		
		    <main class="offset-lg-3 col-lg-9">
        <div class="container-fluid">
            <!-- profile container -->
            <div class="profile-container border d-flex align-items-center">
                <img src="../resources/image/user.jpg" alt="User">
                <div class=" mx-4">
                    <table class="table">
                        <tr>
                            <th><b>Name </b></th>
                            <td>Shubrato Debnath</td>
                        </tr>
                        <tr>
                            <th><b>Email </b></th>
                            <td>shubrato@gmail.com</td>
                        </tr>
                        <tr>
                            <th><b>Joined Loggy </b></th>
                            <td>17 May, 2023</td>
                        </tr>
                    </table>
                </div>
            </div>


            <div class="alert alert-success alert-dismissible fade show" role="alert">
                <strong>Holy guacamole!</strong> You should check in on some of those fields below.
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
            </div>



            <div class="user-blogs-container row">
                <!-- user blog card -->
                <div class="col-lg-4 my-2">
                    <div class="content-box">                        
                        <div class="content-header-info d-flex align-items-center">
                            <!-- user image -->
                            <img class="content-owner-image p-1" src="../resources/image/user.jpg" alt="user">
        
                            <!-- user info -->
                            <div class="">
                                <span class="font-weight-bold pl-3">Shubrato Debnath.</span>
                                <br>
                                <span class="text-muted pl-3">5:10 pm &nbsp; 31 May, 2020</span>
                            </div>
                        </div>
                        <!-- content text -->
                        <div class="content-text my-3">
                            <h4>Serenity at Dusk: A Golden Sea's Gentle Embrace</h4>
                            <p>The sun sets, casting a golden hue upon the tranquil sea, as waves gently lap against the shore in a soothing rhythm.The sun sets, casting a golden hue upon the tranquil sea, as waves gently lap against the shore in a soothing rhythm.</p>
                        </div>
                        <!-- content-multimedia -->
                        <div class="content-multimedia">
                            <img class="card-img" src="../resources/image/img1.jpg" alt="POST">
                        </div>
                        <!-- content interaction -->
                        <div class="content-interaction">
                            <button> <i class="fa-regular fa-heart p-1"></i> Love</button>
                            <a href=""><i class="fa-sharp fa-regular fa-comment p-1"></i> Comment</a>
                            <button>Share</button>
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </main>
		
		
		
	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
		

</body>
</html>