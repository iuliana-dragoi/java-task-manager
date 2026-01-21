package com.example.taskManager;

import com.example.taskManager.model.Task;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(TimingExtension.class)
public class TaskManagerTest {

    private static TaskManager taskManager;
    private static Task task;

    @BeforeEach
    public void setUp() {
        taskManager = new TaskManager();
        task = new Task("TEST");
        assertEquals(0, taskManager.count());
    }

    @Nested
    @DisplayName("Add Task Tests")
    class AddTaskTests {

        @Test
        public void addTask() {
            taskManager.add(task);
            assertTrue(taskManager.exists(task.getId()));
            assertEquals(1, taskManager.count());
        }

        @Test
        public void addTask_duplicateTasks() {
            Task task1 = new Task("Test 2");
            taskManager.add(task);
            taskManager.add(task1);
            assertTrue(taskManager.exists(task.getId()));
            assertTrue(taskManager.exists(task1.getId()));
            assertEquals(2, taskManager.count());
        }

        @ParameterizedTest
        @CsvSource({
                "Task 1, Task 1",
                "Task 2, Task 2",
                "Task 3, Task 3"
        })
        public void addTask_withCvsSource(String description, String expectedDescription) {
            Task task = new Task(description);
            taskManager.add(task);

            Task retrieved = taskManager.getTask(task.getId());
            assertEquals(expectedDescription, retrieved.getDescription());
            assertEquals(task.getId(), retrieved.getId());
        }
    }

    @Nested
    @DisplayName("Get Task Tests")
    class GetTaskTests {

        @Test
        public void getTask() {
            taskManager.add(task);
            Task task1 = taskManager.getTask(task.getId());

            assertAll("Check Task",
                () -> assertEquals("TEST", task1.getDescription()),
                () -> assertTrue(task1.getId() > 0),
                () -> assertEquals(task, task1)
            );
        }
    }

    @Nested
    @DisplayName("Remove Task Tests")
    class RemoveTaskTest {

        @Test
        public void removeTask() {
            taskManager.add(task);
            int preTaskCount = taskManager.count();
            taskManager.remove(task.getId());
            assertFalse(taskManager.exists(task.getId()));
            assertEquals(preTaskCount - 1, taskManager.count());
        }
    }

    @AfterEach
    public void tearUp() {
        TaskIdGenerator.reset();
    }
}
