package com.cwg.dao;

public interface SubjectDao {
    boolean queryByID(String subID);
    boolean delete(String subID);
    boolean insert(String subID,String subject,String kindID);
    boolean update(String subID,String subject,String kindID);
    String queryIdByName (String subject);
}
