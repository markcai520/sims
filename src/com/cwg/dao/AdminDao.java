package com.cwg.dao;


public interface AdminDao {
     boolean queryByUsername(String username);
     boolean queryByInfo(String username,String password);
     boolean addAdmin(String username, String password);
     boolean delete(String adminID);
     boolean insertAdmin(String id,String username,String password);
}
