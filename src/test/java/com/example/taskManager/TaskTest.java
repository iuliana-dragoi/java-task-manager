package com.example.taskManager;

import com.example.taskManager.model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    private static Task task;
    private static final String DESCRIPTION = "TEST";

    @BeforeEach
    public void setUp() {
        task = new Task(DESCRIPTION);
    }

    @Test
    public void getId() {
        assertNotNull(task.getId());
        assertTrue(task.getId() > 0);
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

    @ParameterizedTest
    @ValueSource(strings = {"Write test", "Implement code", "Refactor"})
    public void taskCreation(String description) {
        Task task = new Task(description);
        assertEquals(description, task.getDescription());
        System.out.println(task);
    }
}
