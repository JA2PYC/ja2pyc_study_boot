package com.green.team.bootmvn.controller;

import java.util.List;

import com.green.team.bootmvn.entity.User;
import com.green.team.bootmvn.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/api/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }
}