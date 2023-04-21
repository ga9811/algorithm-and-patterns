package com.yc.jdbc.Utils;



import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public class JDBCUtils {
    //declare variables
    private static String user;
    private static String password;
    private static String url;
    private static String driver;

    static {//this block for initialization


        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src\\mysql properites"));
            //read relative path
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // connect sql, return connection
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void close (ResultSet set, Statement statement, Connection connection){
        // close the connection
try {
    if (set != null) {
        set.close();
    }
    if (statement != null) {
        statement.close();
    }
    if (connection != null) {
        connection.close();
    }
} catch (SQLException e) {
    throw new RuntimeException(e);
}
    }
}
