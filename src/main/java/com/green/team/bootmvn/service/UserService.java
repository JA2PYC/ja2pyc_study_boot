package com.green.team.bootmvn.service;

import java.util.List;

import com.green.team.bootmvn.entity.User;
import com.green.team.bootmvn.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        System.out.println("getAllUsers");
        return userRepository.findAll();
    }
}