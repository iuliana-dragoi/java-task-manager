package com.example.taskManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskTest {

    private static Task task;
    private static final String DESCRIPTION = "TEST";

    @BeforeEach
    public void setUp() {
        task = new Task(DESCRIPTION);
    }

    @Test
    public void getId() {
        assertEquals(1, task.getId());
    }

    @Test
    public void getDescription() {
        assertEquals(DESCRIPTION, task.getDescription());
    }

    @Test
    public void setDescription() {
        task.setDescription(DESCRIPTION + " Updated");
        assertEquals(DESCRIPTION + " Updated", task.getDescription());
    }
}
