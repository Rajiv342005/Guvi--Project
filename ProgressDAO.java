package com.lms.dao;

import com.lms.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProgressDAO {

    public ResultSet getProgressByStudent(int studentId) {

        try {
            Connection con = DBConnection.getConnection();
            String sql = """
                SELECT c.title, p.completed_percentage
                FROM progress p
                JOIN courses c ON p.course_id = c.id
                WHERE p.student_id = ?
            """;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, studentId);
            return ps.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
