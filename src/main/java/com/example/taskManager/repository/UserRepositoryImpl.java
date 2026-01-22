package com.example.taskManager.repository;

import com.example.taskManager.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {

    private Map<Long, User> database = new HashMap();

    @Override
    public User save(User user) {
        return database.put(user.id(), user);
    }

    @Override
    public User findById(Long id) {
        return database.get(id);
    }

    @Override
    public List<User> findAll() {
        return database.values().stream().toList();
    }

    @Override
    public void delete(Long id) {
        database.remove(id);
    }
}
