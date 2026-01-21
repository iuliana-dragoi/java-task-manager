package com.example.taskManager.user;

import com.example.taskManager.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    User user;

    @BeforeEach
    public void setUp() {
        user = new User(1L, "John", "Snow", "12345", "jhon.snow@test.com");
    }

    @Test
    public void getId() {
        assertEquals(1, user.id());
    }

    @Test
    public void getFirstName() {
        assertEquals("John", user.firstName());
    }

    @Test
    public void getLastName() {
        assertEquals("Snow", user.lastName());
    }

    @Test
    public void getPassword() {
        assertEquals("12345", user.password());
    }

    @Test
    public void getEmail() {
        assertEquals("jhon.snow@test.com", user.email());
    }

    @AfterEach
    public void tearUp() {
        user = null;
    }
}
