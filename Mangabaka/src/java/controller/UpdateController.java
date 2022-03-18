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
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tinht
 */
@WebServlet(name = "UpdateController", urlPatterns = {"/UpdateController"})
public class UpdateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ChapterDAO db = new ChapterDAO();
            
            String state = "";
            String name = request.getParameter("currentName");
            int chapter = (request.getParameter("chapter") == null) ? 0 : Integer.valueOf(request.getParameter("chapter"));
            int pageAmount = (request.getParameter("pageAmount") == null) ? 0 : Integer.valueOf(request.getParameter("pageAmount"));
            
            Chapter chap = new Chapter(name, chapter, pageAmount);
            
            db.CreateChapter(chap);
//            state = "Successful!";
//            request.setAttribute("state", state);
            request.getRequestDispatcher("update.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
