package com.lms.dao;
import com.lms.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.lms.model.Course;

public class EnrollmentDAO {

    public boolean enrollStudent(int studentId, int courseId) {

        try {
            Connection con = DBConnection.getConnection();

            // enroll student
            String enrollSql =
                "INSERT INTO enrollments (student_id, course_id) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(enrollSql);
            ps.setInt(1, studentId);
            ps.setInt(2, courseId);
            ps.executeUpdate();

            // create progress record
            String progressSql =
                "INSERT INTO progress (student_id, course_id) VALUES (?, ?)";
            PreparedStatement ps2 = con.prepareStatement(progressSql);
            ps2.setInt(1, studentId);
            ps2.setInt(2, courseId);
            ps2.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public List<Course> getEnrolledCourses(int studentId) {

        List<Course> courses = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            String sql = """
                SELECT c.id, c.title, c.description, c.status
                FROM enrollments e
                JOIN courses c ON e.course_id = c.id
                WHERE e.student_id = ?
            """;

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Course c = new Course();
                c.setId(rs.getInt("id"));
                c.setTitle(rs.getString("title"));
                c.setDescription(rs.getString("description"));
                c.setStatus(rs.getString("status"));
                courses.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return courses;
    }
}
