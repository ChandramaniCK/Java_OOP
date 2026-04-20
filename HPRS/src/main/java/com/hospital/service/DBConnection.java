package com.hospital.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hospital",
                "root",
                "manichandra1712"   // 👉 change to your MySQL password
        );
    }
}