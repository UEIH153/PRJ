<%-- 
    Document   : header
    Created on : Mar 17, 2022, 12:32:59 PM
    Author     : Computer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel = "stylesheet" href="Css/header.css">
        <title>Header</title>
    </head>
    <body>
        <div class="main-header">
                <a href="HomeController">
                    <img class="logo" src="Resource/Thumbnail/logo.png">
                </a>
            <nav class="nav-links">
                    <ul>
                        <li><a href="HomeController">Home</a></li>
                        <li><a href="">Genres</a></li>
                        <li><a href="">New Release</a></li>
                        <li><a href="">Popular</a></li>
                    </ul>
                </nav>
                <div class="search-box">
                    <input class="search-txt" type="text" placeholder="Type to search...">
                    <a class="search-btn" href="#">
                        <i class="fas fa-search"></i>
                    </a>
                </div>
            <c:if test="${sessionScope.type == null}">
                    <a href="login.jsp" class="login">
                        <i class="fas fa-user"></i>
                    </a>
                </c:if>
                <c:if test="${sessionScope.type == 'admin'}">
                    <a href="AdminController" class="login">
                        <i class="fas fa-user"></i>
                    </a>
                </c:if>
                <c:if test="${sessionScope.type == 'normal'}">
                    <a href="ProfileController" class="login">
                        <i class="fas fa-user"></i>
                    </a>
                </c:if> 
                <p class="username">${sessionScope.username}</p>
            </div>
    </body>
</html>
