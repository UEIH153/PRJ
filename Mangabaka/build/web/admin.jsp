<%-- 
    Document   : admin
    Created on : Nov 1, 2021, 3:14:12 PM
    Author     : tinht
--%>

<%@page import="dal.StoryDAO"%>
<%@page import="Entity.Story"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel = "stylesheet" href="Css/header.css">
        <link rel = "stylesheet" href="Css/admin.css">
        <script src="https://kit.fontawesome.com/ff55557564.js" crossorigin="anonymous"></script>
        <title>Admin</title>
        <%
            StoryDAO db = new StoryDAO();
            ArrayList<Story> storyList = db.getAll();
        %>
    </head>
    <body>
        <header>
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
                <a href="LogoutController" class="login">
                    <i class="fas fa-sign-in-alt"></i>
                </a>
                
                <p class="username">${sessionScope.username}</p>
            </div>
        </header>
        <form action="AdminController" method="post">
            <div class="main-view">
                <h1>Admin</h1>
                <div class="card">
                    <input type="submit" name="button" value="Create">
                    <br>
                    <input type="submit" name="button" value="Edit">
                    <br>
                    <input type="submit" name="button" value="Update">
                    <br>
                    <input type="submit" name="button" value="Delete">
                </div>
            </div>
        </form>    
    </body>
</html>
