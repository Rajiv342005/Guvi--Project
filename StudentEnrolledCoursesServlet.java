package com.lms.controller;

import com.lms.dao.EnrollmentDAO;
import com.lms.model.Course;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/student/enrolled")
public class StudentEnrolledCoursesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || !"STUDENT".equals(session.getAttribute("role"))) {
            response.sendRedirect("../login.jsp");
            return;
        }

        int studentId = (int) session.getAttribute("userId");

        EnrollmentDAO dao = new EnrollmentDAO();
        List<Course> courses = dao.getEnrolledCourses(studentId);

        request.setAttribute("courses", courses);
        request.getRequestDispatcher("/studentEnrolledCourses.jsp")
               .forward(request, response);
    }
}
