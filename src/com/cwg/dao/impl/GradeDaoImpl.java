package com.cwg.dao.impl;

import com.cwg.dao.GradeDao;
import com.cwg.model.GradeBean;
import com.cwg.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class GradeDaoImpl implements GradeDao {

    @Override
    public boolean queryByID(String gradeID) {
        boolean flag = false;

        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());

        try {
            GradeBean bean = queryRunner.query("select * from tb_grade where gradeID = ?",new BeanHandler<GradeBean>(GradeBean.class),gradeID);

            if (bean != null)
                flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public boolean delete(String gradeID) {

        boolean flag = false;

        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());

        try {
            int i = queryRunner.update("delete from tb_grade where gradeID = ?",gradeID);

            if (i > 0)
                flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public String queryIdByName(String gradeName) {

        String gradeID = null;

        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());

        try {
            GradeBean bean = queryRunner.query("select * from tb_grade where gradeName = ?",new BeanHandler<GradeBean>(GradeBean.class),gradeName);
            if (bean != null)
                gradeID = bean.getGradeID();
        } catch (SQLException e) {
            System.out.println("查询年级ID时出错！");
            e.printStackTrace();

        }


        return gradeID;
    }

    @Override
    public boolean insert(String gradeID, String gradeName) {

        boolean flag = false;

        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());

        try {
            int i = queryRunner.update("insert into tb_grade value(?,?)",gradeID,gradeName);

            if (i > 0)
                flag = true;
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public boolean update(String gradeID, String gradeName) {

        boolean flag = false;

        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        try {
            int i = queryRunner.update("update tb_grade set gradeName = ? where gradeID = ?",gradeName,gradeID);

            if (i > 0)
                flag = true;
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }
}
