package com.asek.spring.app.service;

import com.asek.spring.app.model.UserModel;

import java.util.List;
import java.util.Map;

public interface UserService {

    Map findById(long id);
    public void saveUser(UserModel u);
    public void saveOrUpdate(UserModel u);
    public void deleteById(long id);
    List getAllUsers();

}
