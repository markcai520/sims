package com.cwg.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.*;

public class C3P0Util {
    static ComboPooledDataSource dataSource = null;

    static {
        dataSource = new ComboPooledDataSource();
    }

    public static ComboPooledDataSource getDataSource() {
        return dataSource;
    }

    /*@Test
    public void test () {
        try {
            System.out.println("------------c3p0连接池链接状态--------------");
            System.out.println("c3p0连接池中 【 总共 】 连接数量："+dataSource.getNumConnectionsDefaultUser());
            System.out.println("c3p0连接池中 【  忙  】 连接数量："+dataSource.getNumBusyConnectionsDefaultUser());
            System.out.println("c3p0连接池中 【 空闲 】 连接数量："+dataSource.getNumIdleConnectionsDefaultUser());
            System.out.println("c3p0连接池中 【未关闭】 连接数量："+dataSource.getNumUnclosedOrphanedConnectionsAllUsers());
        } catch (SQLException e) {
            System.out.println("c3p0连接池异常！");
        }
    }*/

    public static Connection getConn() {
        Connection conn = null;
        try{
            conn = dataSource.getConnection();
        }catch (SQLException e) {
            System.out.println("数据库连接失败");
            e.printStackTrace();
        }
        return conn;
    }

    public static void release (Connection conn,PreparedStatement pst,ResultSet rs) {
        closeRs(rs);
        closePst(pst);
        closeConn(conn);
    }
    public static void release (Connection conn){
        closeConn(conn);
    }

    public static void release (Connection conn,PreparedStatement pst) {
        closePst(pst);
        closeConn(conn);
    }

    private static void closePst(PreparedStatement pst) {
        try {
            if (pst != null)
                pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pst = null;
        }
    }

    private static void closeRs (ResultSet rs) {
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            rs = null;
        }
    }

    private static void closeConn (Connection conn) {
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn = null;
        }
    }

}
