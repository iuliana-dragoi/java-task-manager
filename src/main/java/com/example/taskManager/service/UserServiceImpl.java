package com.example.taskManager.service;

import com.example.taskManager.model.User;
import com.example.taskManager.repository.UserRepository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public CompletableFuture<User> findByIdAsync(Long id) {
        // Simulates an asynchronous call that runs in a separate thread
        return CompletableFuture.supplyAsync(() -> userRepository.findById(id));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }
}
