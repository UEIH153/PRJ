/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Entity.Account;
import java.util.ArrayList;

/**
 *
 * @author tinht
 */
@WebServlet(name = "SignUpServlet", urlPatterns = {"/SignUpServlet"})
public class SignUpController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccountDAO db = new AccountDAO();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String type = "normal";
        String accountState = "";

        //Check account valid
        if (username != null) {
            Account acc = db.AccountValid(username);
            if (acc == null) {
                acc = new Account(0, username, password, firstname, lastname, type);
                db.CreateAccount(acc);
                accountState = "Successful!";
            } else {
                accountState = "Username Exist!";
            }
        }

        request.setAttribute("accountState", accountState);

        //Check account valid
        if (username != null) {
            Account acc = db.AccountValid(username);
            if (acc == null) {
                acc = new Account(0, username, password, firstname, lastname, type);
                db.CreateAccount(acc);
                accountState = "Successful!";
            } else {
                accountState = "Username Exist!";
            }
        }

        request.setAttribute("accountState", accountState);
        request.getRequestDispatcher("signup.jsp").forward(request, response);
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
