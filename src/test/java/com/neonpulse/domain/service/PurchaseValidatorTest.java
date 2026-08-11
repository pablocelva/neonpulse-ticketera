package com.neonpulse.domain.service;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.neonpulse.domain.exception.InvalidQuantityException;

@DisplayName("Purchase Validator (PurchaseValidator)")
class PurchaseValidatorTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("Should throw InvalidQuantityException when quantity is less than or equal to zero")
    void shouldThrowInvalidQuantityExceptionWhenQuantityIsLessOrEqualToZero(int invalidQuantity) {
        // Arrange
        PurchaseValidator validator = new PurchaseValidator();

        // Act & Assert
        assertThatThrownBy(() -> validator.processQuantity(invalidQuantity))
                .isInstanceOf(InvalidQuantityException.class);
    }

    @Test
    @DisplayName("Should process quantity successfully when quantity is valid (greater than zero)")
    void shouldProcessQuantitySuccessfullyWhenQuantityIsValid() {
        // Arrange
        PurchaseValidator validator = new PurchaseValidator();
        int validQuantity = 2;

        // Act & Assert
        assertThatCode(() -> validator.processQuantity(validQuantity))
                .doesNotThrowAnyException();
    }
}