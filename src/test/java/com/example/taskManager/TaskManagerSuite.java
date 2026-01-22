package com.example.taskManager;

import com.example.taskManager.manager.TaskManagerAssumptionTest;
import com.example.taskManager.manager.TaskManagerBackupTest;
import com.example.taskManager.manager.TaskManagerFileTest;
import com.example.taskManager.manager.TaskManagerTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        TaskManagerAssumptionTest.class,
        TaskManagerBackupTest.class,
        TaskManagerFileTest.class,
        TaskManagerTest.class
})
@SelectPackages("com.example.TaskManager.manager")
public class TaskManagerSuite {

}
