package com.cwg.dao;

public interface ExamKindDao {
    boolean queryById(String kindID);
    boolean delete(String kindID);
    boolean insert(String kindID,String kingName);
    boolean update(String kindId,String kindName);
    String queryIdByName (String kindName);
    boolean queryByID(String kindID);
}
