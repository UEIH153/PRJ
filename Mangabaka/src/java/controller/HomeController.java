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
import java.util.ArrayList;
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
@WebServlet(name = "indexController", urlPatterns = {"/HomeController"})
public class HomeController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int pageSize = 3;
        String page = request.getParameter("page");
        int pageIndex = 1;
        try {
            pageIndex = Integer.parseInt(page);
        } catch (Exception e) {
            pageIndex = 1;
        }
        String search = request.getParameter("search");
        if (search == null) {
            search = "";
        }
        StoryDAO storyDao = new StoryDAO();
        int size = storyDao.getSize()/pageSize;
        if(pageIndex>size) pageIndex=size;
        if(pageIndex<1) pageIndex=1;
        ArrayList<Story> list = null;
        if (search.isEmpty()) {
            request.setAttribute("size", size);
            list = storyDao.getAll(pageIndex, pageSize);
        } else {
            list = storyDao.getStorys(search);
        }
        request.setAttribute("page", pageIndex);
        HttpSession session = request.getSession();
        String username = (String) request.getAttribute("username");
        request.setAttribute("username", username);
        request.setAttribute("storyList", list);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
