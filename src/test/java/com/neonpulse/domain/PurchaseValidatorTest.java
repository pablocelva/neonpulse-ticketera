package com.neonpulse.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Test;

import com.neonpulse.domain.PurchaseValidator;
import com.neonpulse.domain.exception.InvalidQuantityException;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

public class PurchaseValidatorTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -50})
    @DisplayName("Should throw InvalidQuantityException when quantity is less than or equal to zero")
    public void shouldThrownInvalidQuantityExceptionWhenQuantityIsLessOrEqualToZero(int invalidQuantity) {
        // Arrange
        PurchaseValidator validator = new PurchaseValidator();

        // Act & Assert
        assertThrows(InvalidQuantityException.class, () -> {
            validator.processQuantity(invalidQuantity);
        });
    }

    @Test
    @DisplayName("Should process quantity successfully when quantity is valid (greater than zero)")
    public void shouldProcessQuantitySuccessfullyWhenQuantityIsValid() {
        // Arrange
        PurchaseValidator validator = new PurchaseValidator();
        int validQuantity = 2;

        // Act & Assert
        assertDoesNotThrow(() -> {
            validator.processQuantity(validQuantity);
        });
    }
}