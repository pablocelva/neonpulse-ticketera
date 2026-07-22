package com.neonpulse.domain;

import com.neonpulse.domain.StockManager;
import com.neonpulse.domain.exception.OutOfStockException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class StockManagerTest {

    @Test
    @DisplayName("Should throw OutOfStockException when inventory is insufficient")
    public void shouldThrowOutOfStockExceptionWhenInventoryIsInsuficient() {
        // Arrange
        int availableStock = 0;
        int requestedQuantity = 1;
        StockManager stockManager = new StockManager();

        // Act & Assert
        assertThrows(OutOfStockException.class, () -> {
            stockManager.checkAvailability(availableStock, requestedQuantity);
        });
    }

    @Test
    @DisplayName("Should not throw any exception when inventory is sufficient")
    public void shouldNotThrowExceptionWhenInventoryIsSufficient() {
        // Arrange
        int availableStock = 5;
        int requestedQuantity = 2;
        StockManager stockManager = new StockManager();

        // Act & Assert
        assertDoesNotThrow(() -> {
            stockManager.checkAvailability(availableStock, requestedQuantity);
        });
    }
}