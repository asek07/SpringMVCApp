package com.asek.spring.app.dao;

import com.asek.spring.app.model.UserModel;

import java.util.Map;
import java.util.List;

public interface UserDao {

    Map findById(long id);
    public void saveUser(UserModel u);
    public void saveOrUpdate(UserModel u);
    public void deleteById(long id);
    //TODO:
    //implement get all table results from mysql into json
   List getAllUsers();
   void updateUser(UserModel u);

}
