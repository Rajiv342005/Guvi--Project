package com.lms.controller;

import com.lms.dao.CourseDAO;
import com.lms.model.Course;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/admin/courses")
public class AdminCourseServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || !"ADMIN".equals(session.getAttribute("role"))) {
            response.sendRedirect("../login.jsp");
            return;
        }

        CourseDAO dao = new CourseDAO();
        List<Course> courses = dao.getPendingCourses();

        request.setAttribute("courses", courses);
        request.getRequestDispatcher("/adminCourses.jsp")
               .forward(request, response);
    }
}
