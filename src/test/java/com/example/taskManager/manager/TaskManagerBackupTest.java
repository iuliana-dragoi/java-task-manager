package com.example.taskManager.manager;

import com.example.taskManager.TaskManager;
import com.example.taskManager.model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskManagerBackupTest {

    TaskManager taskManager;

    @BeforeEach
    void setUp() {
        taskManager = new TaskManager();
    }

    @Test
    void saveTasksToFile(@TempDir Path tempDir) throws IOException {
        Task task = new Task("Backup Task");
        taskManager.add(task);

        Path backupFile = tempDir.resolve("tasks.txt");
        Files.writeString(backupFile, taskManager.getTask(task.getId()).getDescription());

        String content = Files.readString(backupFile);
        assertEquals("Backup Task", content);
    }
}