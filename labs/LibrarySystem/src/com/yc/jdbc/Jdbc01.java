package com.yc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Jdbc01 {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/yc_library_system";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "ga981008");


        
        Connection connect = DriverManager.getConnection(url, properties);

        String sql = "INSERT INTO Books VALUES (20, 'Pride', '1853-01-28', 1, 18.99, 'Romance', TRUE)";

        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql);
        System.out.println(rows > 0 ? "success" : "error");
        statement.close();
        connect.close();
    }
}


