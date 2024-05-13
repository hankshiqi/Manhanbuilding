package com.hank.mhl.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class UtilsBydruid {
    private static DataSource ds;
    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src\\druid.properties"));
            ds= DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection() throws Exception {
        return ds.getConnection();
    }
    public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) throws Exception {
        if (rs!= null) {
            rs.close();
        }
        if (pstmt!= null) {
            pstmt.close();
        }
        if (conn!= null) {
            conn.close();//注意这里的断开连接并不是真的断开连接而是将这个连接放回连接池中，下次有线程需要连接的时候，会从连接池中取出一个连接来使用。
        }
    }
}
