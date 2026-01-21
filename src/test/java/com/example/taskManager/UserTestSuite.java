package com.example.taskManager;

import com.example.taskManager.user.UserRoleTest;
import com.example.taskManager.user.UserTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    UserTest.class,
    UserRoleTest.class
})
@SelectPackages("com.example.TaskManager.user")
public class UserTestSuite {
}
