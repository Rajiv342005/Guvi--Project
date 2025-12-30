package com.lms.controller;

import com.lms.util.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // Handles FORM SUBMISSION (POST)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT id, role FROM users WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
            	int userId = rs.getInt("id");
            	String role = rs.getString("role");
                System.out.println("Role from DB: [" + role + "]");
                HttpSession session = request.getSession();
                session.setAttribute("userId", userId);
                session.setAttribute("email", email);
                session.setAttribute("role", role);

                if ("ADMIN".equals(role)) {
                    response.sendRedirect(request.getContextPath() + "/adminDashboard.jsp");
                } else if ("INSTRUCTOR".equals(role)) {
                    response.sendRedirect(request.getContextPath() + "/instructorDashboard.jsp");
                } else if ("STUDENT".equals(role)) {
                    response.sendRedirect(request.getContextPath() + "/studentDashboard.jsp");
                }

            } else {
                response.sendRedirect("login.jsp?error=1");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Handles DIRECT URL ACCESS (GET)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }
}

