package com.luv2code.springdemo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

    public static void main(String [] args) {
        String DB_URL = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
        String DB_USER = "hbstudent";
        String DB_PASSWORD = "hbstudent";

        try {
            System.out.println(
                String.format("Connecting to DB: %s", DB_URL)
            );

            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            System.out.println("Connection Succeeded");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
