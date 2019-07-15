package com.cwg.dao.impl;

import com.cwg.dao.TeacherDao;
import com.cwg.model.StudentBean;
import com.cwg.model.TeacherBean;
import com.cwg.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class TeacherDaoImpl implements TeacherDao {

    @Override
    public boolean insert(String teaID, String classID, String teaName, String sex, String knowledge, String level) {
        boolean flag = false;

        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());

        try {
            int i = queryRunner.update("insert into tb_teacher value(?,?,?,?,?,?)",teaID,classID,teaName,sex,knowledge,level);

            if (i > 0)
                flag = true;
        } catch (SQLException e) {
            System.out.println("插入教师信息出错");
        }

        return flag;
    }

    @Override
    public boolean update(String teaID, String classID, String teaName, String sex, String knowledge, String level) {
        boolean flag = false;

        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());

        try {
            int i = queryRunner.update("update tb_teacher set classID = ?,teaName = ?,sex = ?,knowledge = ?,level = ? where teaID = ?",classID,teaName,sex,knowledge,level,teaID);

            if (i > 0)
                flag = true;
        } catch (SQLException e) {
            System.out.println("更新编号" + teaID + "的教师信息时出错");
        }

        return flag;
    }

    @Override
    public boolean delete(String teaID) {
        boolean flag = false;

        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());

        try {
            int i = queryRunner.update("delete from tb_teacher where teaID = ?",teaID);

            if (i > 0)
                flag = true;
        } catch (SQLException e) {
            System.out.println("删除教师信息出错");
        }

        return flag;
    }

    @Override
    public boolean queryById(String teaID) {
        boolean flag = false;

        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());

        try {

            TeacherBean bean = queryRunner.query("select * from tb_teacher where teaID = ?",new BeanHandler<TeacherBean>(TeacherBean.class),teaID);

            if (bean != null)
                flag = true;

        } catch (SQLException e) {
            System.out.println("查询编号为" + teaID + "的教师信息出错");
        }

        return flag;
    }
}
