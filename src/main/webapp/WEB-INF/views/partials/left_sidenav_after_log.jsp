<%@page import="loggy.entities.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
    User user = new User(); 
	if(session.getAttribute("user") != null){
		user = (User) session.getAttribute("user");
	}
    %>
    <!-- navbar design -->
    <nav class="col-lg-3 border side-navbar">
        <div class="navbar-brand">
            <a href="#">Loggy</a>
        </div>

        <ul class="nav-links">
            <li class="nav-link">
                <a href="#"><i class="fa-solid fa-house nav-icon"></i><span>Home</span></a>
            </li>
            <li class="nav-link">
                <a href="#"> <img class="user_image_nav" alt="user" src="resources/image/userImages/<%=user.getImage() %>"> <span><%=user.getName() %></span></a>
            </li>  
            <li class="nav-link">
                <a href="#"><i class="fa-solid fa-gear nav-icon"></i><span>Settings</span></a>
            </li>
			<li class="nav-link">
                <a href="logout"><i class="fa-solid fa-gear nav-icon"></i><span>Logout</span></a>
            </li>    
            
        </ul>
    </nav>

    