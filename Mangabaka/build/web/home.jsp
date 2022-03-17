<%-- 
    Document   : home
    Created on : Oct 30, 2021, 4:01:56 PM
    Author     : tinht
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Entity.Story"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dal.StoryDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mangabaka</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel = "stylesheet" href="Css/header.css">
        <link rel = "stylesheet" href="Css/mainView.css">
        <link rel = "stylesheet" href="Css/popularView.css">
        <script src="https://kit.fontawesome.com/ff55557564.js" crossorigin="anonymous"></script>
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
                <div class="search-box">
                    <input class="search-txt" type="text" placeholder="Type to search...">
                    <a class="search-btn" href="#">
                        <i class="fas fa-search"></i>
                    </a>
                </div>
                <c:if test="${sessionScope.type == null}">
                    <a href="LoginController" class="login">
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
        </header>
        
        <div class="main-view">
            <div class="thumb-view">
                <div class="card">
                    <div class="detail">
                        <h1>One Piece</h1>
                        <p>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star-half-alt"></i>
                            </br>
                            </br>
                            One Piece is a Japanese manga series written and illustrated by Eiichiro Oda. 
                            It has been serialized in Shueisha's shōnen manga magazine Weekly Shōnen Jump 
                            since July 1997, with its individual chapters compiled into 100 tankōbon volumes 
                            as of September 2021. The story follows the adventures of Monkey D. Luffy, a boy 
                            whose body gained the properties of rubber after unintentionally eating a Devil Fruit. 
                            With his crew of pirates, named the Straw Hat Pirates, Luffy explores the Grand Line 
                            in search of the world's ultimate treasure known as "One Piece" in order to become the 
                            next King of the Pirates.
                        </p>    
                    </div>
                    
                    
                    <div class="btn-read">
                        <a href="ReadController?name=OnePiece&chapter=1">
                            <button id="btn-readnow">Read Now</button>
                        </a>
                        
                        <button id="btn-moreinfo">
                            <i class="fas fa-info-circle"></i>
                            More Information
                        </button>
                    </div>
                    
                </div>
            </div>
            <div class="popular-view">
                <div class="row-Header-title">
                    <h1>New Release</h1>
                </div>
                
                <div class="slider-bar">
                    
                    <c:forEach items="${storyList}" var="story">
                        <div class="item-container">
                            <a class="item" href="ReadController?name=${story.getName()}&chapter=1">
                                <img src="${story.getThumbnail()}">
                                <h1>${story.getName()}</h1>
                            </a>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </body>
</html>
