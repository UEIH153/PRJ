<%-- 
    Document   : create
    Created on : Nov 3, 2021, 10:41:46 AM
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
        <title>Create</title>
    </head>
    <body>
        <header>
            <div class="main-header">
                <a href="HomeController">
                    <img class="logo" src="Resource/Thumbnail/logo.png">
                </a>
            </div>
        </header>
        <form action="CreateController" method="get">
            <div class="main-view">
                <h1>Admin</h1>
                <div class="card-create">
                    <h2>Create</h2>
                    <div class="container">
                        <p>Name: </p>
                        <input type="text" name="name" placeholder="Enter Username..." value="${name}">
                    </div>
                    <div class="container">
                        <p>Chapter Amount: </p>
                        <input type="text" name="chapterAmount" placeholder="Enter Chapter Amount..." value="${chapterAmount}">
                    </div>
                    <div class="container">
                        <p>Author: </p>
                        <input type="text" name="author" placeholder="Enter Author..." >
                    </div>
                    <div class="container">
                        <p>Description: </p>
                        <input type="text" name="status" placeholder="Enter Status..." value="${status}">
                    </div>
                    <div class="container">
                        <p>Thumbnail: </p>
                        <input type="file" name="thumbnail">
                    </div>
                    <div class="container">
                        <input type="submit" name="button" value="Create">
                    </div>
                    <div>
                        <p>${storyState}</p>
                    </div>
                </div>
            </div>
        </form>    
    </body>
</html>
