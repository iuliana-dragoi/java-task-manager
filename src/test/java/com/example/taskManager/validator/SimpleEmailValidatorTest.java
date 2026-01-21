package com.example.taskManager.validator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleEmailValidatorTest {

    private final EmailValidator validator = new SimpleEmailValidator();

    @ParameterizedTest
    @ValueSource(strings = {"test@test.com", "john.snow@gmail.com", "user_name@example.com", "user123@example.com"})
    public void validEmails(String email) {
        assertTrue(validator.isValid(email));
    }

    @ParameterizedTest
    @ValueSource(strings = {"user@", "@example.com", "user@exa_mple.com", "user@example", "user@example.123"})
    public void invalidEmails(String email) {
        assertFalse(validator.isValid(email));
    }
}
