package com.example.taskManager.service;

import com.example.taskManager.model.User;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface UserService {

    User create(User user);
    User findById(Long id);
    CompletableFuture<User> findByIdAsync(Long id);
    List<User> findAll();
    void delete(Long id);
}
