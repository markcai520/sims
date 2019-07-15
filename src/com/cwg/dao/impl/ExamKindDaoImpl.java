package com.cwg.dao.impl;


import com.cwg.dao.ExamKindDao;
import com.cwg.model.ExamkindBean;
import com.cwg.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExamKindDaoImpl implements ExamKindDao {

    @Override
    public boolean queryById(String kindID) {
        boolean flag = false;

        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());

        try {
            ExamkindBean bean = queryRunner.query("select * from tb_examkind where kindID = ?",new BeanHandler<ExamkindBean>(ExamkindBean.class),kindID);

            if (bean != null)
                flag = true;
        } catch (SQLException e) {
            System.out.println("查询考试种类表失败");
        }

        return flag;
    }

    @Override
    public boolean delete(String kindID) {
        boolean flag = false;

        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());

        try {
            int i = queryRunner.update("delete from tb_examkind where kindID = ?",kindID);
            if (i > 0)
                flag = true;
        } catch (SQLException e) {
            System.out.println("删除考试种类信息时出错");
        }

        return flag;
    }

    @Override
    public boolean insert(String kindID, String kindName) {
        boolean flag = false;

        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());

        try {
            int i = queryRunner.update("insert into tb_examkind value(?,?)",kindID,kindName);
            if (i > 0)
                flag = true;
        } catch (SQLException e) {
            System.out.println("添加考试种类信息时出错");
        }

        return flag;
    }

    @Override
    public boolean update(String kindId, String kindName) {
        boolean flag = false;

        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());

        try {
            int i = queryRunner.update("update tb_examkind set kindName = ? where kindID = ?",kindName,kindId);
            if (i > 0)
                flag = true;
        } catch (SQLException e) {
            System.out.println("修改考试种类信息时出错");
        }

        return flag;
    }

    @Override
    public String queryIdByName(String kindName) {
        String kindID = null;

        Connection conn = C3P0Util.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String sql = "select kindID from tb_examkind where kindName = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1,kindName);
            rs = pst.executeQuery();

            while (rs.next()) {
                kindID = rs.getString("kindID");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return kindID;
    }

    @Override
    public boolean queryByID(String kindID) {
        boolean flag = false;

        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());

        try {
            ExamkindBean bean = queryRunner.query("select * from tb_examkind where kindID = ?",new BeanHandler<ExamkindBean>(ExamkindBean.class),kindID);

            if (bean != null)
                flag = true;
        } catch (SQLException e) {
            System.out.println("查询考试种类被时出错");
        }

        return flag;
    }
}
