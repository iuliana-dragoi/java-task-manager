package com.example.taskManager;

import com.example.taskManager.model.Task;

import java.util.HashMap;
import java.util.Map;

public class TaskManager {

    private Map<Long, Task> tasks;

    public TaskManager() {
        tasks = new HashMap<>();
    }

    public void add(Task task) {
        tasks.put(task.getId(), task);
    }

    public boolean exists(Long id) {
        return tasks.containsKey(id);
    }

    public int count() {
        return tasks.size();
    }

    public void remove(Long id) {
        tasks.remove(id);
    }

    public Task getTask(Long id) {
        return tasks.get(id);
    }
}
