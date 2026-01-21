package com.example.taskManager.validator;

import com.example.taskManager.TimingExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(TimingExtension.class)
public class SimpleEmailValidatorTest {

    private final EmailValidator validator = new SimpleEmailValidator();

    @ParameterizedTest(name = "email={0}")
    @DisplayName("Valid emails test")
    @ValueSource(strings = {"test@test.com", "john.snow@gmail.com", "user_name@example.com", "user123@example.com"})
    public void validEmails(String email) {
        assertTrue(validator.isValid(email));
    }

    @ParameterizedTest(name = "email={0}")
    @DisplayName("Invalid emails test")
    @ValueSource(strings = {"user@", "@example.com", "user@exa_mple.com", "user@example", "user@example.123"})
    public void invalidEmails(String email) {
        assertFalse(validator.isValid(email));
    }
}
