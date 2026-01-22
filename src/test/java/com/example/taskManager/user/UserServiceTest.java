package com.example.taskManager.user;

import com.example.taskManager.model.User;
import com.example.taskManager.repository.UserRepository;
import com.example.taskManager.service.UserService;
import com.example.taskManager.service.UserServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserServiceTest {


    @Test
    public void findById() {
        // create mock repo
        UserRepository userRepositoryMock = mock(UserRepository.class);

        User mockUser = new User(1L, "John", "Doe", "john.doe@example.com", "password");

        // when method "findById" is called with argument 1, return mockUser.
        when(userRepositoryMock.findById(mockUser.id())).thenReturn(mockUser);

        // inject the mock repository into the service
        UserService userService = new UserServiceImpl(userRepositoryMock);

        User result = userService.findById(1L);

        assertEquals(mockUser, result);

        // verify that the repository method was called once
        verify(userRepositoryMock).findById(1L);
    }
}
