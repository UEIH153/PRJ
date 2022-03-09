<%-- 
    Document   : delete
    Created on : Nov 3, 2021, 11:31:49 AM
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
        <title>Delete</title>
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
        <form action="DeleteController" method="get">
            <div class="main-view">
                <h1>Admin</h1>
                <div class="card-delete">
                    <h2>Delete</h2>
                    <p>${updateState}</p>
                    <div class="container">
                        <select name="currentName">
                            <%
                                for(Story story : storyList) {
                            %>
                            <option>
                                <%= story.getName() %>
                            </option>
                            <%}%>
                        </select>
                    </div>
                    <div class="container">
                        <input type="submit" name="button" value="Delete">
                    </div>
                    <div>
                        <p>${storyState}</p>
                    </div>
                </div>
            </div>
        </form>  
    </body>
</html>
