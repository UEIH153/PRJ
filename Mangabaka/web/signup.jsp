<%-- 
    Document   : signup
    Created on : Oct 28, 2021, 5:43:02 PM
    Author     : tinht
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel = "stylesheet" href="Css/signup.css">
        <script src="https://kit.fontawesome.com/ff55557564.js" crossorigin="anonymous"></script>
        <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    </head>
    <body>
        <header>
            <div class="main-header">
                <img class="logo" src="Resource/Thumbnail/logo.png">
            </div>
            
        </header>
        <form action="SignUpServlet" method="post">
            <div class="main-view">
                <a class="backLogin" href="login.jsp">
                    <i class="fas fa-long-arrow-alt-left"></i>
                    Login
                </a>
                <div class="card">
                    <h1>Sign up</h1>
                     
                    <p class="accountState"> ${accountState} </p>
                    <p>Username</p>
                    <div class="inputInfo">
                        <i class="fas fa-user fa-color"></i>
                        <input type="text" name="username" placeholder="Enter Username..." >
                    </div>

                    <p>Password</p>

                    <div class="inputInfo">
                        <i class="fas fa-lock fa-color"></i>
                        <input type="password" name="password" placeholder="Enter Password..."><br>
                    </div>

                    <p>First Name</p>

                    <div class="inputInfo">
                        <input type="text" name="firstname" placeholder="Enter Password..."><br>
                    </div>

                    <p>Last Name</p>

                    <div class="inputInfo">
                        <input type="text" name="lastname" placeholder="Enter Password..."><br>
                    </div>

                    <input type="submit" value="Sign up"><br>

                    <p class="loginWith">Or Sign Up With</p><br>
                    <div class="loginWithIcon">
                        <i class="fab fa-facebook fa-2x"></i>
                        <i class="fab fa-twitter fa-2x"></i>
                        <i class="fab fa-google fa-2x"></i>
                    </div>


                </div>
            </div>
        </form>
        
    </body>
</html>
