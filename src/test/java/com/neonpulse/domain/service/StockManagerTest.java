package com.neonpulse.domain.service;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.neonpulse.domain.exception.OutOfStockException;

@DisplayName("Stock Manager (StockManager)")
class StockManagerTest {

    @Test
    @DisplayName("Should throw OutOfStockException when inventory is insufficient")
    void shouldThrowOutOfStockExceptionWhenInventoryIsInsufficient() {
        // Arrange
        int availableStock = 0;
        int requestedQuantity = 1;
        StockManager stockManager = new StockManager();

        // Act & Assert
        assertThatThrownBy(() -> stockManager.checkAvailability(availableStock, requestedQuantity))
                .isInstanceOf(OutOfStockException.class);
    }

    @Test
    @DisplayName("Should not throw any exception when inventory is sufficient")
    void shouldNotThrowExceptionWhenInventoryIsSufficient() {
        // Arrange
        int availableStock = 5;
        int requestedQuantity = 2;
        StockManager stockManager = new StockManager();

        // Act & Assert
        assertThatCode(() -> stockManager.checkAvailability(availableStock, requestedQuantity))
                .doesNotThrowAnyException();
    }
}