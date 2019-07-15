package com.cwg.dao;


public interface GradeSubDao {
    boolean insert (String stuID, String stuName, String kindID, String subID, double grade,String classID);
    boolean delete (String stuID, String kindID, String subID);
    boolean update (String stuID, String kindID, String subID, double grade);
    boolean queryById(String stuID,String kindID);
    boolean delete(String stuID);
}
