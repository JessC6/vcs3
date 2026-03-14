package com.nhlstenden;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest
{

    @Test
    void getAge_value26_shouldPass()
    {
        // Arrange
        User user1 = new User("Marta", "Gomez", LocalDate.parse("2000-01-06"));

        // Act
        int result = user1.getAge();

        // Assert
        assertEquals(26, result);
    }
}