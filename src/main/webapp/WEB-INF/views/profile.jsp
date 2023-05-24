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

</body>
</html>