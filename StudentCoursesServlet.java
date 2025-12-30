package com.lms.controller;

import com.lms.dao.CourseDAO;
import com.lms.model.Course;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/student/courses")
public class StudentCoursesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || !"STUDENT".equals(session.getAttribute("role"))) {
            response.sendRedirect("../login.jsp");
            return;
        }

        CourseDAO dao = new CourseDAO();
        List<Course> courses = dao.getApprovedCourses();

        request.setAttribute("courses", courses);
        request.getRequestDispatcher("/studentCourses.jsp")
               .forward(request, response);
    }
}
