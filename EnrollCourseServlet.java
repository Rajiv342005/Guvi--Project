package com.lms.controller;
import java.io.IOException;
import com.lms.dao.EnrollmentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/enrollCourse")
public class EnrollCourseServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || !"STUDENT".equals(session.getAttribute("role"))) {
            response.sendRedirect("login.jsp");
            return;
        }
        int studentId = (int) session.getAttribute("userId");
        int courseId = Integer.parseInt(request.getParameter("id"));

        EnrollmentDAO dao = new EnrollmentDAO();
        dao.enrollStudent(studentId, courseId);

        response.sendRedirect(request.getContextPath() + "/student/courses");
    }
}
