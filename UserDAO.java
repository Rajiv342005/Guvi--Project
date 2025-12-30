package com.lms.dao;

import com.lms.model.User;
import com.lms.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT id, name, email, role FROM users";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setEmail(rs.getString("email"));
                u.setRole(rs.getString("role"));

                users.add(u);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }
    public boolean deleteUserById(int id) {

        try {
            Connection con = DBConnection.getConnection();
            String sql = "DELETE FROM users WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    } 
    public boolean updateUser(int id, String name, String email, String role) {

        try {
            Connection con = DBConnection.getConnection();
            String sql = "UPDATE users SET name=?, email=?, role=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, role);
            ps.setInt(4, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
public boolean insertUser(String name, String email, String password, String role) {

    try {
        Connection con = DBConnection.getConnection();
        String sql = "INSERT INTO users (name, email, password, role) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, password);
        ps.setString(4, role);

        int rows = ps.executeUpdate();
        return rows > 0;

    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}
}