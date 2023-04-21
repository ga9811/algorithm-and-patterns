package com.yc.jdbc.Utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtilsByDruid {
    private static DataSource ds;
    //static data block ds initialized
    static {
        Properties properties = new Properties();
        try {
            properties.load (new FileInputStream("src\\druid.properties") );
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    // getConnection method
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if(resultSet != null){
                resultSet.close();
            }
            if(statement != statement){
                statement.close();
            }
            if(connection !=null){
                connection.close();
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
}
