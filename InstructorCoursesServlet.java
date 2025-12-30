package com.lms.controller;

import com.lms.dao.CourseDAO;
import com.lms.model.Course;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/instructor/courses")
public class InstructorCoursesServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || !"INSTRUCTOR".equals(session.getAttribute("role"))) {
            response.sendRedirect("../login.jsp");
            return;
        }

        Integer instructorId = (Integer) session.getAttribute("userId");

        CourseDAO dao = new CourseDAO();
        List<Course> courses = dao.getCoursesByInstructor(instructorId);

        request.setAttribute("courses", courses);
        request.getRequestDispatcher("/instructorDashboard.jsp")
               .forward(request, response);
    }
}
