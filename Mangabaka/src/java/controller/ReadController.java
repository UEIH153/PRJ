/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Entity.Chapter;
import Entity.Story;
import dal.ChapterDAO;
import dal.StoryDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tinht
 */
@WebServlet(name = "ReadController", urlPatterns = {"/ReadController"})
public class ReadController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StoryDAO storyDB = new StoryDAO();
        ChapterDAO chapterDB = new ChapterDAO();

        String name = request.getParameter("name");
        int chapter = (request.getParameter("chapter") == null) ? 0 : Integer.valueOf(request.getParameter("chapter"));
        Story story = storyDB.GetStory(name);
        Chapter chap = chapterDB.GetChapter(name, chapter);

        request.setAttribute("story", story);
        request.setAttribute("chap", chap);
        request.setAttribute("chapter", chapter);

        request.getRequestDispatcher("read.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("read.jsp").forward(request, response);
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
