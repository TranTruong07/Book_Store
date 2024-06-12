/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.UserDao;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.User;
import service.BookService;

/**
 *
 * @author Admin
 */
public class LoginServlet extends HttpServlet {

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
        BookService bookService = BookService.getInstance();
        request.setAttribute("listc", bookService.getAllCategory());
        request.getRequestDispatcher("Views/Login.jsp").forward(request, response);
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
        String user_name = request.getParameter("username");
        String pass = request.getParameter("pass");
        UserDao ud = new UserDao();
        User u = ud.getUser(user_name, pass);
        HttpSession session = request.getSession();
        BookService bookService = BookService.getInstance();
        if (u == null) {
            request.setAttribute("listc", bookService.getAllCategory());
            request.setAttribute("msg_f", "Email or Password invalid");
            request.getRequestDispatcher("Views/Login.jsp").forward(request, response);
            return;
        }

        if (u.getStatusId() != 1) {
            request.setAttribute("listc", bookService.getAllCategory());
            request.setAttribute("msg_f", "Your account is lock!!!!");
            request.getRequestDispatcher("Views/Login.jsp").forward(request, response);
            return;
        }
        // role: 1-Admin, 2-User
        session.setAttribute("user", u);
        if (u.getRoleId() == 1) {
            response.sendRedirect("HomeAdmin");
        } else {
            response.sendRedirect("Home");
        }

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
