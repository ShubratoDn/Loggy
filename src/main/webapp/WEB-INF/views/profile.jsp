<%@page import="loggy.entities.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%
	User loggedUser = null; 
	if(session.getAttribute("user") != null){
		loggedUser = (User) session.getAttribute("user");
	}
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%loggedUser.getName() %></title>

	<%@include file="partials/header-links.jsp"%>

</head>
<body>

	

</body>
</html>