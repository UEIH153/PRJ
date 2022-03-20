/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Entity.Story;
import dal.StoryDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tinht
 */
@WebServlet(name = "EditStory", urlPatterns = {"/EditStory"})
public class EditStory extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       request.getRequestDispatcher("editStory.jsp").forward(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         StoryDAO db = new StoryDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        Story story = db.get(id);
        String name = request.getParameter("name");
        String author = "";
        String status = request.getParameter("status");
        String link = "Resource/Story/" + name;
        String thumbnail = "Resource/Thumbnail/" + request.getParameter("thumbnail");
        story.setAuthor(author);
        story.setName(name);
        story.setStatus(status);
        story.setThumbnail(thumbnail);
        db.UpdateStory(story);
        request.setAttribute("state", "Update success!");
        request.getRequestDispatcher("editStory.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
