<%-- 
    Document   : update
    Created on : Nov 3, 2021, 10:44:53 AM
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
        <title>Update</title>
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


                <p class="username">${sessionScope.username}</p>
            </div>
        </header>
        <form action="UpdateController" method="post">
            <div class="main-view">
                <h1>Admin</h1>
                <div class="card-update">
                    <h2>Add Chapter</h2>
                    <div class="container">
                        <select name="currentName">
                            <%
                                for (Story story : storyList) {
                            %>
                            <option>
                                <%= story.getName()%>
                            </option>
                            <%}%>
                        </select>
                    </div>
                    <div class="container">
                        <p>Chapter: </p>
                        <input type="number" name="chapter" placeholder="Enter Chapter...">
                    </div>
                    <div class="container">
                        <p>Page Amount: </p>
                        <input type="number" name="pageAmount" placeholder="Enter Page Amount...">
                    </div>
                    <div class="container">
                        <input type="submit" name="button" value="Add Chapter">
                    </div>
                    <div>
                        <p>${state}</p>
                    </div>
                </div>
            </div>
        </form>  
    </body>
</html>
