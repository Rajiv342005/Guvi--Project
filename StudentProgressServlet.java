package com.lms.controller;

import java.io.IOException;
import java.sql.ResultSet;

import com.lms.dao.ProgressDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/student/progress")
public class StudentProgressServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || !"STUDENT".equals(session.getAttribute("role"))) {
            response.sendRedirect("../login.jsp");
            return;
        }

        int studentId = (int) session.getAttribute("userId");

        ProgressDAO dao = new ProgressDAO();
        ResultSet rs = dao.getProgressByStudent(studentId);
        request.setAttribute("progress", rs);
        request.getRequestDispatcher("/studentProgress.jsp")
               .forward(request, response);
    }
}
