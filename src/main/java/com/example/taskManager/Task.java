package com.example.taskManager;

public class Task {

    private long id;

    private String description;

    public Task(String description) {
        this.id = TaskIdGenerator.nextId();
        this.description = description;
    }

    public long getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
