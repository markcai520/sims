package com.cwg.dao.impl;

import com.cwg.dao.GradeSubDao;
import com.cwg.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GradeSubDaoImpl implements GradeSubDao {
    @Override
    public boolean insert(String stuID, String stuName, String kindID, String subID, double grade,String classID) {
        boolean flag = false;

        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());

        String sql = "insert into tb_grade_sub value(?,?,?,?,?,null,?)";

        try {
            int i = queryRunner.update(sql,stuID,stuName,kindID,subID,grade,classID);
            if (i > 0)
                flag = true;
        } catch (SQLException e) {
            System.out.println("插入成绩信息时出错");
        }

        return flag;
    }

    @Override
    public boolean delete(String stuID, String kindID, String subID) {
        boolean flag = false;

        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());

        String sql = "delete from tb_grade_sub where stuID = ? and kindID = ? and subID = ?";

        try {
            int i = queryRunner.update(sql,stuID,kindID,subID);
            if (i > 0)
                flag = true;
        } catch (SQLException e) {
            System.out.println("删除成绩信息时出错");
        }

        return flag;
    }

    @Override
    public boolean update(String stuID, String kindID, String subID, double grade) {
        boolean flag = false;


        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());

        String sql = "update tb_grade_sub set grade = ? where stuID =? and kindID = ? and subID = ?";



        try {
            int i = queryRunner.update(sql,grade,stuID,kindID,subID);
            if (i > 0)
                flag = true;
        } catch (SQLException e) {
            System.out.println("修改成绩信息时出错");
        }

        return flag;
    }

    @Override
    public boolean queryById(String stuID,String kindID) {
        boolean flag = false;

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = C3P0Util.getConn();
            String sql = "select * from tb_grade_sub where stuID = ? and kindID = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1,stuID);
            pst.setString(2,kindID);

            rs = pst.executeQuery();

            while (rs.next()) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3P0Util.release(conn,pst,rs);
        }


        return flag;
    }

    @Override
    public boolean delete(String stuID) {
        boolean flag = false;

        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());

        try {
            int i = queryRunner.update("delete from tb_grade_sub where stuID = ?",stuID);

            if (i > 0)
                flag = true;
        } catch (SQLException e) {
            System.out.println("删除学生成绩时出错");
        }

        return flag;
    }
}
