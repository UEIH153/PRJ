<%-- 
    Document   : readpage
    Created on : Oct 31, 2021, 2:39:12 PM
    Author     : tinht
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Entity.Chapter"%>
<%@page import="Entity.Story"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel = "stylesheet" href="Css/read.css">
        <link rel = "stylesheet" href="Css/header.css">
        <script src="https://kit.fontawesome.com/ff55557564.js" crossorigin="anonymous"></script>
        <title>Mangabaka</title>
        <%
            Story story = (Story)request.getAttribute("story");
            Chapter chap = (Chapter)request.getAttribute("chap");
            int chapter = 1;
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
                <div class="search-box">
                    <input class="search-txt" type="text" placeholder="Type to search...">
                    <a class="search-btn" href="#">
                        <i class="fas fa-search"></i>
                    </a>
                </div>
                <a class="login">
                    <i class="fas fa-user"></i>
                    <a href=""></a>
                </a>
                <p class="username">${sessionScope.username}</p>
            </div>
        </header>      
            <div class="main-read">
            <div class="read">
                <%
                    String name = story.getName();
                %>
                <%
                    for(int i = 1; i <= chap.getPageAmount(); i++) {
                %>
                        <img class="storyImg" src="Resource/Story/<%=name%>/<%=chap.getChapter()%>/<%=i%>.png">         
                <%}%>
            </div>
        </div>
            <footer>
            <div class="main-footer">
                <div class="level">
                    <div class="left-level">
                        <ul class="list-01">
                            <li>
                                <a href="HomeController">
                                    <i class="fas fa-home"></i>
                                    <span>Home</span>
                                </a>
                            </li>
                            <li>
                                <a href="">
                                    <i class="fas fa-bug"></i>
                                    <span>Report</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                    <div class="center-level">
                        <div class="back">
                            <a href="">
                                <i class="fas fa-arrow-circle-left fa-customize fa-color"></i>
                            </a>
                        </div>
                        <select id="dynamic_select" selected="selected" class="chapter" name="chapter" onchange="location = this.value">
                            <option value="${chapter}" selected disable hidden>Chapter ${chapter}</option>
                            <%
                                for(int i = 1; i <= story.getChapterAmount(); i++) {
                            %>
                            <option value="ReadController?name=${story.getName()}&chapter=<%=i%>">
                                    Chapter <%=i%>
                            </option>
                            <%}%>
                            
                        </select>
                        <div class="next">
                            <a href="">
                                <i class="fas fa-arrow-circle-right fa-customize fa-color"></i>
                            </a>
                        </div>
                    </div>
                    <div class="right-level">
                        <ul class="list-01">
                            <li>
                                <a href="HomeController">
                                    <i class="far fa-lightbulb"></i>
                                    <span>Light</span>
                                </a>
                            </li>
                            <li>
                                <a href="">
                                    <i class="far fa-heart"></i>
                                    <span>Follow</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
                
            </div>     
            
        </footer>  
    </body>
</html>
