package com.lms.controller;

import com.lms.dao.CourseDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/createCourse")
public class CreateCourseServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || !"INSTRUCTOR".equals(session.getAttribute("role"))) {
            response.sendRedirect("login.jsp");
            return;
        }

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String syllabus = request.getParameter("syllabus");

        Integer instructorIdObj = (Integer) session.getAttribute("userId");
        if (instructorIdObj == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int instructorId = instructorIdObj;


        CourseDAO dao = new CourseDAO();
        dao.createCourse(title, description, syllabus, instructorId);

        response.sendRedirect("instructorDashboard.jsp");
    }
}
