<%-- 
    Document   : up
    Created on : Nov 10, 2021, 1:45:58 PM
    Author     : tinht
--%>

<%@page import="Entity.Story"%>
<%@page import="dal.StoryDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h1>
                <%
                    String idString = request.getParameter("id");
                    int id = Integer.parseInt(idString);
                    StoryDAO storyDAO = new StoryDAO();
                    Story story = storyDAO.get(id);
                    request.setAttribute("story", story);
                %>
                <%=story.getName()%>
            </h1>
            <form action="EditStory" method="Post">
                <input name="id" value="${story.id}" type="hidden"/>
                Name <input name="name" type="text" value="${story.name}"><br>
                Status <input name="status" type="text" value="${story.status}"><br>
                Thumbnail <input name="thumbnail" type="file"><br>
                <input type="submit">
            </form>     
        </div>       
    </body>
</html>
