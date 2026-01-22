package com.example.taskManager.task;

import com.example.taskManager.TaskIdGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;

public class TaskIdGeneratorTest {

    @BeforeEach
    void resetId() {
        TaskIdGenerator.reset();
    }

    @Test
    void testNextId_staticMock() {
        try (MockedStatic<TaskIdGenerator> mockedStatic = mockStatic(TaskIdGenerator.class)) {

            mockedStatic.when(TaskIdGenerator::nextId).thenReturn(100L, 101L);

            long first = TaskIdGenerator.nextId();
            long second = TaskIdGenerator.nextId();

            assertEquals(100, first);
            assertEquals(101, second);

            mockedStatic.verify(TaskIdGenerator::nextId, times(2));
        }
    }

    @Test
    void testReset_staticMock() {
        try (MockedStatic<TaskIdGenerator> mockedStatic = mockStatic(TaskIdGenerator.class)) {
            TaskIdGenerator.reset();
            mockedStatic.verify(TaskIdGenerator::reset, times(1));
        }
    }

    @Test
    void nextId_shouldIncrementId() {
        long firstId = TaskIdGenerator.nextId();
        long secondId = TaskIdGenerator.nextId();
        long thirdId = TaskIdGenerator.nextId();

        assertEquals(1, firstId);
        assertEquals(2, secondId);
        assertEquals(3, thirdId);
    }

    @Test
    void reset_shouldSetIdBackToOne() {
        TaskIdGenerator.nextId();
        TaskIdGenerator.nextId();

        TaskIdGenerator.reset();

        long idAfterReset = TaskIdGenerator.nextId();
        assertEquals(1, idAfterReset);
    }
}
