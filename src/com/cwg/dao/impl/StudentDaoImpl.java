package com.cwg.dao.impl;

import com.cwg.dao.StudentDao;
import com.cwg.model.StudentBean;
import com.cwg.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class StudentDaoImpl implements StudentDao {

    @Override
    public boolean insert(String stuID, String classID, String stuName, String sex, int age, String addr, String phone) {
        boolean flag = false;

        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());

        try {
            int i = queryRunner.update("insert into tb_student value(?,?,?,?,?,?,?)",stuID,classID,stuName,sex,age,addr,phone);

            if (i > 0)
                flag = true;
        } catch (SQLException e) {
            System.out.println("插入学生信息出错");
        }

        return flag;
    }

    @Override
    public boolean update(String stuID, String classID, String stuName, String sex, int age, String addr, String phone) {
        boolean flag = false;

        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());

        try {
            int i = queryRunner.update("update tb_student set classID = ?,stuName = ?,sex = ?,age = ?,addr = ?,phone = ? where stuID = ?",classID,stuName,sex,age,addr,phone,stuID);

            if (i > 0)
                flag = true;
        } catch (SQLException e) {
            System.out.println("更新学号" + stuID + "的学生信息时出错");
        }

        return flag;
    }

    @Override
    public boolean delete(String stuID) {
        boolean flag = false;

        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());

        try {
            int i = queryRunner.update("delete from tb_student where stuID = ?",stuID);

            if (i > 0)
                flag = true;
        } catch (SQLException e) {
            System.out.println("删除学生信息出错");
        }

        return flag;
    }

    @Override
    public boolean queryById(String stuID) {
        boolean flag = false;

        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());

        try {

            StudentBean bean = queryRunner.query("select * from tb_student where stuID = ?",new BeanHandler<StudentBean>(StudentBean.class),stuID);

            if (bean != null)
                flag = true;

        } catch (SQLException e) {
            System.out.println("查询学号" + stuID + "的学生信息出错");
        }

        return flag;
    }
}
