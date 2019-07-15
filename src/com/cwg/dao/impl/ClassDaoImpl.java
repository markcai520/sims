package com.cwg.dao.impl;

import com.cwg.dao.ClassDao;
import com.cwg.model.ClassBean;
import com.cwg.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class ClassDaoImpl implements ClassDao {

    @Override
    public boolean queryById(String classID,String gradeID) {
        boolean flag = false;

        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        try {
            ClassBean bean = queryRunner.query("select * from tb_class where classID = ? and gradeID = ?",new BeanHandler<ClassBean>(ClassBean.class),classID,gradeID);

            if (bean != null)
                flag = true;

        } catch (SQLException e) {
            System.out.print("查询编号为" + classID + "的信息时出错");
        }

        return flag;
    }

    @Override
    public boolean queryById(String classID) {
        boolean flag = false;

        QueryRunner queryRunner = new QueryRunner (C3P0Util.getDataSource());

        try {
            ClassBean bean = queryRunner.query("select * from tb_class where classID = ?",new BeanHandler<ClassBean>(ClassBean.class),classID);

            if (bean != null)
                flag = true;

        } catch (SQLException e) {
            System.out.println("在查询编号为" + classID + "的班级信息时出错");
        }

        return flag;
    }

    @Override
    public String queryIdByName(String className) {
        String classID = null;

        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());

        try {
            ClassBean bean = queryRunner.query("select * from tb_class where className = ?",new BeanHandler<ClassBean>(ClassBean.class),className);

            if (bean != null) {
                classID = bean.getClassID();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return classID;
    }

    @Override
    public boolean update(String gradeID, String classID, String className) {
        boolean flag = false;

        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());

        try {
            int i = queryRunner.update("update tb_class set className = ? where gradeID = ? and classID = ?",className,gradeID,classID);

            if (i > 0)
                flag = true;
        } catch (SQLException e) {
            System.out.println("更新班级表出错");
        }

        return flag;
    }

    @Override
    public boolean insert(String gradeID, String classID, String className) {
        boolean flag = false;

        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());

        try {
            int i = queryRunner.update("insert into tb_class value(?,?,?)",classID,gradeID,className);

            if (i > 0)
                flag = true;
        } catch (SQLException e) {
            System.out.println("更新班级表出错");
        }

        return flag;
    }

    @Override
    public boolean delete(String gradeID, String classID) {

        boolean flag = false;

        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());

        try {
            int i = queryRunner.update("delete from tb_class where gradeID = ? and classID = ?",gradeID,classID);
            if (i > 0)
                flag = true;
        } catch (SQLException e) {
            System.out.println("删除班级信息出错");
        }

        return flag;

    }
}
