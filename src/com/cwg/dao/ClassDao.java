package com.cwg.dao;

public interface ClassDao {
    boolean queryById(String classID,String gradeID);
    boolean queryById(String classID);
    String queryIdByName (String className);
    boolean update(String gradeID,String classID,String className);
    boolean insert(String gradeID,String classID,String className);
    boolean delete(String gradeID,String classID);
}
