<%-- 
    Document   : header
    Created on : Mar 17, 2022, 12:32:59 PM
    Author     : Computer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel = "stylesheet" href="Css/header.css">
        <title>Header</title>
    </head>
    <body>
        

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
                        <select selected="selected" class="chapter" name="chapter" onchange="location = this.value">
                            <option value="" selected disabled hidden>Chapter <%=chap.getChapter()%></option>
                            <%
                                for(int i = story.getChapterAmount(); i >= 1; i--) {
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
