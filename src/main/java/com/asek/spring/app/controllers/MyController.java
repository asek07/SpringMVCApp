package com.asek.spring.app.controllers;


import com.asek.spring.app.model.UserModel;
import com.asek.spring.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MyController {

    @Autowired
    private UserService service;

    @RequestMapping("/")
    public String returnData() {

        UserModel u = new UserModel();
        u.setFave_colour("purple");

        service.saveUser(u);
        return "This is working!";
    }

    @RequestMapping("/user/{userID}")
    public Map getUserData(@PathVariable String userID) {
        return service.findById(Long.parseLong(userID));
    }
}
