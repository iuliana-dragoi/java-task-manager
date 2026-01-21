package com.example.taskManager.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskManagerFileTest {

    @TempDir
    Path tempDir;

    @Test
    void testCreateFileInTempDir() throws IOException {
        Path file = tempDir.resolve("testfile.txt");
        Files.writeString(file, "Hello JUnit 5");

        String content = Files.readString(file);
        assertEquals("Hello JUnit 5", content);
    }

    @Test
    void testWithTempDirParameter(@TempDir Path tempDir) throws IOException {
        Path file = tempDir.resolve("data.txt");
        Files.writeString(file, "Data for test");

        assertTrue(Files.exists(file));
    }
}
