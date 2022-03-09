<%-- 
    Document   : up
    Created on : Nov 10, 2021, 1:45:58 PM
    Author     : tinht
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <%
                String name = request.getParameter("name");
                request.setAttribute("currentName", name);
            %>
            <%=name%>
        </h1>
        <form action="EditStory?currentName=<%=name%>" method="Post">
            <%
                request.setAttribute("currentName", request.getParameter("name"));
            %>
            Name <input name="name" type="text"><br>
            Status <input name="status" type="text"><br>
            Thumbnail <input name="thumbnail" type="file"><br>
            <input type="submit">
        </form>            
    </body>
</html>
