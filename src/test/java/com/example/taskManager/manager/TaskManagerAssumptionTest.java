package com.example.taskManager.manager;
import com.example.taskManager.TaskManager;
import com.example.taskManager.model.Task;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class TaskManagerAssumptionTest {

    @Test
    public void testOnlyOnJava21() {
        assumeTrue(System.getProperty("java.version").startsWith("17"),
                "Test skipped: Only for Java 21");
        // ...
    }

    @Test
    void testOnlyOnDevEnvironment() {
        assumeTrue("development".equals(System.getenv("ENVIRONMENT")),
                "Skipped: Not in development environment");

        //...
    }

    @Test
    void testWithConditionalLogic() {
        TaskManager manager = new TaskManager();

        assumingThat(System.getProperty("os.name").startsWith("Linux"), () -> {
            manager.add(new Task("Linux task"));
            assertEquals(1, manager.count());
        });

        manager.add(new Task("General task"));
        assertEquals(1, manager.count());
    }
}
