package com.example.taskManager.repository;

import com.example.taskManager.model.User;

import java.util.List;

public interface UserRepository {

    User save(User user);
    User findById(Long id);
    List<User> findAll();
    void delete(Long id);
}
