package com.cwg.dao.impl;

import com.cwg.dao.SubjectDao;
import com.cwg.model.SubjectBean;
import com.cwg.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class SubjectDaoImpl implements SubjectDao {
    @Override
    public boolean queryByID(String subID) {

        boolean flag = false;

        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());

        try {
            SubjectBean bean = queryRunner.query("select * from tb_subject where subID = ?",new BeanHandler<SubjectBean>(SubjectBean.class),subID);
            if (bean != null)
                flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public boolean delete(String subID) {

        boolean flag = false;

        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());

        try {

            int i = queryRunner.update("delete from tb_subject where subID = ?",subID);

            if (i > 0)
                flag = true;

        } catch (SQLException e) {
            System.out.println("科目" + subID + "已被其他表引用,无法删除！");
        }

        return flag;
    }

    @Override
    public boolean insert(String subID, String subject,String kindID) {

        boolean flag = false;

        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());

        try {

            int i = queryRunner.update("insert into tb_subject value(?,?,?)",subID,subject,kindID);

            if (i > 0)
                flag = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;

    }

    @Override
    public boolean update(String subID, String subject,String kindID) {

        boolean flag = false;

        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());

        try {

            int i = queryRunner.update("update tb_subject set subject = ?,kindID = ? where subID = ?",subject,kindID,subID);

            if (i > 0)
                flag = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public String queryIdByName(String subject) {
        String subID = null;

        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());

        try {
            SubjectBean bean = queryRunner.query("select * from tb_subject where subject = ?",new BeanHandler<SubjectBean>(SubjectBean.class),subject);
            subID = bean.getSubID();
        } catch (SQLException e) {
            System.out.println("查询ID失败");
        }

        return subID;
    }
}
