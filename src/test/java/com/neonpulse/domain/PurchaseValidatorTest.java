package com.neonpulse.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import com.neonpulse.domain.exception.InvalidQuantityException;

import static org.junit.jupiter.api.Assertions.*;

public class PurchaseValidatorTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -50})
    
    // iterara sobre el source:
    // primero evaluara el 0
    // despues el -1
    // por ultimo el -50

    public void shouldThrownInvalidQuantityExceptionWhenQuantityIsLessOrEqualToZero(int invalidQuantity) {
        // Arrange
        PurchaseValidator validator = new PurchaseValidator();

        // Act & Assert
        assertThrows(InvalidQuantityException.class, () -> {
            validator.processQuantity(invalidQuantity);
        });
    }
}