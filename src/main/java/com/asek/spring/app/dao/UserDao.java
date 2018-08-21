package com.asek.spring.app.dao;

import com.asek.spring.app.model.UserModel;

import java.util.Map;

public interface UserDao {

    Map findById(long id);
    public void saveUser(UserModel u);
    public void saveOrUpdate(UserModel u);
    public void deleteById(long id);

}
