package com.lms.controller;

import com.lms.dao.UserDAO;
import com.lms.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/admin/users")
public class AdminServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserDAO dao = new UserDAO();
        List<User> users = dao.getAllUsers();

        request.setAttribute("users", users);
        request.getRequestDispatcher("/adminDashboard.jsp")
               .forward(request, response);
    }
}
