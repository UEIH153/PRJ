<%-- 
    Document   : editStory
    Created on : Nov 4, 2021, 10:10:30 AM
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
        <title>Edit Story</title>
        <%
            StoryDAO db = new StoryDAO();
            ArrayList<Story> storyList = db.getAll();
        %>
    </head>
    <body>
        <header>
            <div class="main-header"  style="position: relative!important">
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
        <form action="EditStory" method="get" style="margin-top: 20px">
            <div class="table-data">
                
            </div>
            <table border="1">
                <tr>
                    <td>Name</td>
                    <td>Status</td>
                    <td>Thumbnail</td>
                </tr>
                <%
                    for(Story s : storyList) {
                %>
                <tr>
                    <td><%=s.getName()%></td>
                    <td><%=s.getStatus()%></td>
                    <td><%=s.getThumbnail()%></td>
                    <td>
                        <a href="up.jsp?id=<%=s.getId()%>">
                            Update
                        </a>
                    </td>
                    <td>
                        <a href="DeleteController?currentName=<%=s.getName()%>">
                            Delete
                        </a>
                    </td>
                </tr>
                <%}%>
            </table>
            
            <div class="main-view" >
                <h1>Admin</h1>
                <div class="card-update">
                    <h2>Edit Story</h2>
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
                        <p>New Name: </p>
                        <input type="text" name="name" placeholder="Enter Username...">
                    </div>
                    <div class="container">
                        <p>Description: </p>
                        <input type="text" name="status" placeholder="Enter Status...">
                    </div>
                    <div class="container">
                        <p>Thumbnail: </p>
                        <input type="file" name="thumbnail">
                    </div>
                    <div class="container">
                        <input type="submit" name="button" value="Update">
                    </div>
                    <div>
                        <p>${state}</p>
                    </div>
                </div>
            </div>
        </form>  
    </body>
</html>
