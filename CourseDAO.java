package com.lms.dao;
import com.lms.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import com.lms.model.Course;

public class CourseDAO {

    public boolean createCourse(String title, String description,
                                String syllabus, int instructorId) {

        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO courses (title, description, syllabus, instructor_id) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, title);
            ps.setString(2, description);
            ps.setString(3, syllabus);
            ps.setInt(4, instructorId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public List<Course> getCoursesByInstructor(int instructorId) {

        List<Course> courses = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM courses WHERE instructor_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, instructorId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Course c = new Course();
                c.setId(rs.getInt("id"));
                c.setTitle(rs.getString("title"));
                c.setDescription(rs.getString("description"));
                c.setSyllabus(rs.getString("syllabus"));
                c.setStatus(rs.getString("status"));
                c.setInstructorId(rs.getInt("instructor_id"));

                courses.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return courses;
    }
    public List<Course> getPendingCourses() {

        List<Course> courses = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM courses WHERE status = 'PENDING'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Course c = new Course();
                c.setId(rs.getInt("id"));
                c.setTitle(rs.getString("title"));
                c.setDescription(rs.getString("description"));
                c.setSyllabus(rs.getString("syllabus"));
                c.setStatus(rs.getString("status"));
                c.setInstructorId(rs.getInt("instructor_id"));
                courses.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return courses;
    }
    public void approveCourse(int courseId) {
        updateCourseStatus(courseId, "APPROVED");
    }

    public void rejectCourse(int courseId) {
        updateCourseStatus(courseId, "REJECTED");
    }

    private void updateCourseStatus(int courseId, String status) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "UPDATE courses SET status=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, status);
            ps.setInt(2, courseId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Course> getApprovedCourses() {

        List<Course> courses = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM courses WHERE status='APPROVED'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Course c = new Course();
                c.setId(rs.getInt("id"));
                c.setTitle(rs.getString("title"));
                c.setDescription(rs.getString("description"));
                c.setStatus(rs.getString("status"));
                c.setInstructorId(rs.getInt("instructor_id"));
                courses.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return courses;
    }

}
