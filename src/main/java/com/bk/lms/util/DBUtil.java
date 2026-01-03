package com.bk.lms.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

    private static final String URL =
        System.getenv("DB_URL") != null ?
        System.getenv("DB_URL") :
        "jdbc:mysql://localhost:3306/lms";

    private static final String USER =
        System.getenv("DB_USER") != null ?
        System.getenv("DB_USER") : "root";

    private static final String PASSWORD =
        System.getenv("DB_PASS") != null ?
        System.getenv("DB_PASS") : "7061";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
