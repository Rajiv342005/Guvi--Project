package com.lms.controller;

import com.lms.dao.UserDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        UserDAO dao = new UserDAO();
        boolean inserted = dao.insertUser(name, email, password, role);

        if (inserted) {
            response.sendRedirect("admin/users");
        } else {
            response.sendRedirect("addUser.jsp");
        }
    }
}
