package com.cwg.util;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class JDBCAdapter {
    public boolean BuildeDeleteTempView(String sqlState) {

        boolean flag = false;
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = C3P0Util.getConn();
            pstmt = con.prepareStatement(sqlState);
            pstmt.execute();
            flag = true;
        } catch (java.sql.SQLException sql) {
            flag = false;
            sql.printStackTrace();
        }
        return flag;
    }
}