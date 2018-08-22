package com.asek.spring.app.service;

import com.asek.spring.app.dao.UserDao;
import com.asek.spring.app.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("studentService")
public class UserServiceImpl implements  UserService {

    @Autowired
    private UserDao dao;

    @Override
    public Map findById(long id) {
       return dao.findById(id);
    }

    @Override
    public void saveUser(UserModel u) {
        dao.saveUser(u);
    }

    @Override
    public void saveOrUpdate(UserModel u) {
        dao.saveOrUpdate(u);
    }

    @Override
    public void deleteById(long id) {
        dao.deleteById(id);
    }

    @Override
    public List getAllUsers() {
       return dao.getAllUsers();
    }
}
