package com.lms.util;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    // STEP 1: Change DATABASE NAME if yours is different
    private static final String URL =
        "jdbc:mysql://127.0.0.1:3306/lms_db";

    // STEP 2: Change USERNAME if not root
    private static final String USER = "root";

    // STEP 3: Change PASSWORD to YOUR MySQL password
    private static final String PASSWORD = "Rajiv@789";

    public static Connection getConnection() {
        Connection con = null;
        try {
            // STEP 4: Load MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // STEP 5: Create connection
            con = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
class TestDB {
    public static void main(String[] args) {
        if (DBConnection.getConnection() != null) {
            System.out.println("Database connected successfully");
        } else {
            System.out.println("Database connection failed");
        }
    }
}
