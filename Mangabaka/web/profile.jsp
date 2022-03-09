<%-- 
    Document   : profile
    Created on : Nov 3, 2021, 12:55:23 PM
    Author     : tinht
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel = "stylesheet" href="Css/header.css">
        <link rel = "stylesheet" href="Css/admin.css">
        <script src="https://kit.fontawesome.com/ff55557564.js" crossorigin="anonymous"></script>
        <title>JSP Page</title>
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
        <form action="ProfileController" method="get">
            <div class="main-view">
                <h1>Profile</h1>
                <div class="card-profile">
                    <h2>Update Profile</h2>
                    <div class="container">
                        <p>New Username: </p>
                        <input type="text" name="name" placeholder="Enter Username..." value="${username}">
                    </div>
                    <div class="container">
                        <p>New Password: </p>
                        <input type="password" name="password" placeholder="Enter Password..." value="${password}">
                    </div>
                    <div class="container">
                        <p>Confirm Password: </p>
                        <input type="password" name="confirmPassword" placeholder="Confirm Password...">
                    </div>
                    <div class="container">
                        <p>First Name: </p>
                        <input type="text" name="firstname" placeholder="Enter First Name..." value="${firstname}">
                    </div>
                    <div class="container">
                        <p>Last Name: </p>
                        <input type="text" name="lastname" placeholder="Enter Last Name..." value="${lastname}">
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
