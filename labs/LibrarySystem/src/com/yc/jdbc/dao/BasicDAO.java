package com.yc.jdbc.dao;

import com.yc.jdbc.Utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.util.List;

public class BasicDAO<T> {
    private QueryRunner qr = new QueryRunner();
    // create generic dml methods
    public int update(String sql, Object... parameters) {
        Connection connection = null;
        try {

            connection = JDBCUtilsByDruid.getConnection();
            int updated = qr.update(connection, sql, parameters);
            return updated;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null,null, connection);
        }

    }

    // create mulitypal rows select methods
    public List<T> queryMulti(String sql, Class<T>clazz, String parameters) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection, sql, new BeanListHandler<>(clazz),parameters);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null,null, connection);
        }
    }
    // select single row
    public  T querySingle(String sql, Class<T> clazz, Object... parameters) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection, sql, new BeanHandler<T>(clazz), parameters);


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }
        // select single row and single column
        public Object queryScalar(String sql, Object... parameters){
            Connection connection = null;
            try{
                connection = JDBCUtilsByDruid.getConnection();
                return qr.query(connection,sql,new ScalarHandler(),parameters);
            }catch (Exception e) {
                throw new RuntimeException(e);
            }finally {
                JDBCUtilsByDruid.close(null,null,connection);
            }
        }
    }


