package com.cwg.dao;

public interface GradeDao {
    boolean queryByID(String gradeID);
    boolean delete(String gradeID);
    String queryIdByName(String gradeName);
    boolean insert(String gradeID,String gradeName);
    boolean update(String gradeID,String gradeName);
}
