package com.asek.spring.app.controllers;


import com.asek.spring.app.model.UserModel;
import com.asek.spring.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MyController {

    @Autowired
    private UserService service;

    @RequestMapping("/")
    public String returnData() {

        UserModel u = new UserModel();
        u.setName("John");
        u.setFave_colour("purple");

        service.saveUser(u);
        return "This is working!";
    }

    @RequestMapping("/user/{userID}")
    public Map getUserData(@PathVariable String userID) {

        return service.findById(Long.parseLong(userID));
    }

    @RequestMapping(value="/users/addUser", produces = {"application/json"}, method = RequestMethod.POST)
    public String addOrUpdateUser(@RequestParam("name") String name, @RequestParam("fave_colour") String colour) {

        String output = name + " " + colour;
        UserModel user = new UserModel();

        name = name.trim();
        colour = colour.trim();

        user.setName(name);
        user.setFave_colour(colour);

        service.saveOrUpdate(user);

        return output;
    }

    @RequestMapping("/user/delete/{userID}")
    public String deleteUser(@PathVariable String userID) {

        service.deleteById(Long.parseLong(userID));

        return "Deleting user ID=" + userID;
    }

    @RequestMapping("/allusers")
    public List getAll() {
        return service.getAllUsers();
    }
}
