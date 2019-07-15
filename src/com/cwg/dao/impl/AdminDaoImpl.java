package com.cwg.dao.impl;

import com.cwg.dao.AdminDao;
import com.cwg.model.AdminBean;
import com.cwg.util.C3P0Util;
import com.mchange.v2.c3p0.DataSources;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.sql.DataSource;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {

    @Override
    public boolean queryByUsername(String username) {

        boolean flag = false;

        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());

        try {
            AdminBean bean = queryRunner.query("select * from tb_admin where username = ?",new BeanHandler<AdminBean>(AdminBean.class),username);
            if (bean != null)
                flag = true;
        } catch (SQLException e) {
            System.out.println("在管理员表中查询:" + username + "时出错");
        }

        return flag;

    }

    @Override
    public boolean queryByInfo(String username, String password) {

        boolean flag = false;

        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());

        AdminBean bean = new AdminBean();

        try {
            bean = queryRunner.query("select * from tb_admin where username = ? and password = ?",new BeanHandler<AdminBean>(AdminBean.class),username,password);
        } catch (SQLException e) {
            System.out.println("在管理员表中使用用户名:" + username + " + 密码:" + password + "查询失败");
        }

        if (bean != null)
            flag = true;


        return flag;

    }

    @Override
    public boolean addAdmin(String username, String password) {

        boolean flag = false;

        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());

        String adminID = username.substring(0,2) + (int)(Math.random()*100 + 1);

        try {
            int result = queryRunner.update("insert into tb_admin value(?,?,?)",adminID,username,password);

            if (result > 0)
                flag = true;
        }catch (SQLException e) {
            System.out.println("注册管理员失败");
        }

        return flag;

    }

    @Override
    public boolean delete(String adminID) {

        boolean flag = false;

        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());

        try {
            int result = queryRunner.update("delete from tb_admin where adminID = ?",adminID);

            if (result > 0)
                flag = true;
        } catch (SQLException e) {
            System.out.println("删除信息时出错");
        }

        return flag;
    }

    @Override
    public boolean insertAdmin(String id, String username, String password) {

        boolean flag = false;

        DataSource dataSource = C3P0Util.getDataSource();

        QueryRunner queryRunner = new QueryRunner(dataSource);

        try {
            int i = queryRunner.update("insert into tb_admin value(?,?,?)",id,username,password);

            if (i > 0)
                flag = true;
        } catch (SQLException e) {
            System.out.println("添加管理员失败");
        }

        return flag;

    }

}
