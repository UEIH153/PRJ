<%-- 
    Document   : login
    Created on : Oct 25, 2021, 10:03:30 AM
    Author     : tinht
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel = "stylesheet" href="Css/login.css">
        <script src="https://kit.fontawesome.com/ff55557564.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <header>
            <div class="main-header">
                <a href="HomeController">
                    <img class="logo" src="Resource/Thumbnail/logo.png">
                </a>
            </div>
            
        </header>
        <form action="LoginController" method="">
            <div class="main-view">
                <div class="card">
                    <h1>Login</h1>
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


                    <a href="#" class="forgotPass"><p>Forgot password?</p></a><br>
                    <input type="submit" value="Login"><br>

                    <p class="loginWith">Or Login With</p><br>
                    <div class="loginWithIcon">
                        <i class="fab fa-facebook fa-2x"></i>
                        <i class="fab fa-twitter fa-2x"></i>
                        <i class="fab fa-google fa-2x"></i>
                    </div>
                    <div class="signUp">
                        <a href="SignUpServlet">SIGN UP</a>
                    </div>
                </div>
            </div>
        </form>
        
    </body>
</html>
