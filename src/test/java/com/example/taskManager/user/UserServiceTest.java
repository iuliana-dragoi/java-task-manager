package com.example.taskManager.user;

import com.example.taskManager.model.User;
import com.example.taskManager.repository.UserRepository;
import com.example.taskManager.service.UserServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

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

    @Nested
    @DisplayName("Find by Id Tests")
    class FindByIdTest {

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

        @Test void findAll() {
            User mockUser1 = new User(1L, "John1", "Doe1", "john.doe1@example.com", "password1");
            User mockUser2 = new User(2L, "John2", "Doe2", "john.doe2@example.com", "password2");
            User mockUser3 = new User(3L, "John3", "Doe3", "john.doe3@example.com", "password3");
            when(userRepositoryMock.findAll()).thenReturn(List.of(mockUser1, mockUser2, mockUser3));

            List<User> result = userService.findAll();
            verify(userRepositoryMock).findAll();
            assertEquals(3, result.size());
        }
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

    @Test
    void deleteUser() {
        User mockUser = new User(1L, "John", "Doe", "john.doe@example.com", "password");
        doNothing().when(userRepositoryMock).delete(1L);
        when(userRepositoryMock.findById(1L)).thenReturn(null);

        userService.delete(mockUser.id());
        User result = userService.findById(mockUser.id());

        verify(userRepositoryMock).delete(mockUser.id());
        verify(userRepositoryMock).findById(mockUser.id());
        assertNull(result);
    }
}
