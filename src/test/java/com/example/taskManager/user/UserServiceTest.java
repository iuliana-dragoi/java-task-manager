package com.example.taskManager.user;

import com.example.taskManager.model.User;
import com.example.taskManager.repository.UserRepository;
import com.example.taskManager.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepositoryMock;

    @InjectMocks
    private UserServiceImpl userService;

    @Captor
    ArgumentCaptor<User> userCaptor;

    @Test
    public void findById() {
        User mockUser = new User(1L, "John", "Doe", "john.doe@example.com", "password");
        when(userRepositoryMock.findById(mockUser.id())).thenReturn(mockUser);

        User result = userService.findById(1L);
        assertEquals(mockUser, result);
        verify(userRepositoryMock).findById(1L);
    }

    @Test
    public void findById_nonExisting() {
        when(userRepositoryMock.findById(3L)).thenReturn(null);
        assertNull(userService.findById(3l));
        verify(userRepositoryMock).findById(3L);
    }

    @Test
    public void findById_twoUsers() {
        User mockUser1 = new User(1L, "John", "Doe", "john.doe@example.com", "password");
        User mockUser2 = new User(2L, "John", "Doe", "john.doe@example.com", "password");

        when(userRepositoryMock.findById(1L)).thenReturn(mockUser1);
        when(userRepositoryMock.findById(2L)).thenReturn(mockUser2);

        userService.findById(mockUser1.id());
        userService.findById(mockUser2.id());

        verify(userRepositoryMock).findById(1L);
        verify(userRepositoryMock).findById(2L);
    }

    @Test
    void createUser_capturesUser() {
        User mockUser = new User(1L, "John", "Doe", "john.doe@example.com", "password");
        when(userRepositoryMock.save(mockUser)).thenReturn(mockUser);

        userService.create(mockUser);
        verify(userRepositoryMock).save(userCaptor.capture());

        User savedUser = userCaptor.getValue();
        assertEquals("John", savedUser.firstName());
    }
}
