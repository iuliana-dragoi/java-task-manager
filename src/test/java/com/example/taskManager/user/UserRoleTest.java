package com.example.taskManager.user;

import com.example.taskManager.UserRole;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import static org.junit.jupiter.api.Assertions.*;

public class UserRoleTest {

    @ParameterizedTest
    @EnumSource(value = UserRole.class, names = {"ADMIN"})
    public void rolesWithWritePermission(UserRole role) {
        assertTrue(role.hasWritePermission);
    }

    @ParameterizedTest
    @EnumSource(value = UserRole.class, names = {"USER", "GUEST"})
    public void rolesWithoutReadPermission(UserRole role) {
        assertFalse(role.hasWritePermission);
    }
}
