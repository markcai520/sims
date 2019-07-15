package com.cwg.dao;

public interface StudentDao {
    boolean insert (String stuID,String classID,String stuName,String sex,int age,String addr,String phone);
    boolean update (String stuID,String classID,String stuName,String sex,int age,String addr,String phone);
    boolean delete (String stuID);
    boolean queryById (String stuID);
}
