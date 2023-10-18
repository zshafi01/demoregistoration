package com.example.demoregistoration.service;

import com.example.demoregistoration.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    void deleteUser(Long id);
}
