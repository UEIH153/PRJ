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
@WebServlet(name = "CreateStory", urlPatterns = {"/CreateController"})
public class CreateController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            StoryDAO db = new StoryDAO();
            
            String createState; 
            String name = request.getParameter("name");
            String author = request.getParameter("author");
            String status = request.getParameter("status");
            String link = "Resource/Story/" + name;
            String thumbnail = "Resource/Thumbnail/" + request.getParameter("thumbnail");
            int chapterAmount = (request.getParameter("chapterAmount") == null) ? 0 : Integer.valueOf(request.getParameter("chapterAmount"));
            
            Story story = new Story(name, chapterAmount, status, link, thumbnail, author);
            
            if(name == null) 
                createState = "";
            else {
                if(db.GetStory(name) == null && status != null && chapterAmount != 0 && thumbnail != null) {
                    db.CreateStory(story);
                    createState = "Successfull!";
                }
                else
                    createState = "Story not valid!";
            }
            
            request.setAttribute("storyState", createState);
            request.getRequestDispatcher("create.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
