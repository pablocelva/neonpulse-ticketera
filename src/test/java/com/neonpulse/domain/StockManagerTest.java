package com.neonpulse.domain;

import com.neonpulse.domain.exception.OutOfStockException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StockManagerTest {

    @Test
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
}