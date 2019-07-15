package com.cwg.dao;

public interface TeacherDao {
    boolean insert (String teaID,String classID,String teaName,String sex,String knowledge,String level);
    boolean update (String teaID,String classID,String teaName,String sex,String knowledge,String level);
    boolean delete (String teaID);
    boolean queryById (String teaID);
}
