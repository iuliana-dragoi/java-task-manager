package com.example.taskManager.service;

import com.example.taskManager.model.User;

import java.util.List;

public interface UserService {

    User create(User user);
    User findById(Long id);
    List<User> findAll();
    void delete(Long id);
}
