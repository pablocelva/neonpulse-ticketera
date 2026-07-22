package com.neonpulse.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.neonpulse.domain.ShoppingCart;

public class ShoppingCartTest {
    
    @Test
    public void shouldInitializeCartWithZeroTotalAndEmptyListAndNameCarrito() {
        // Arrange
        ShoppingCart cart = new ShoppingCart();

        // Act
        double actualTotal = cart.getTotal();
        boolean isListEmpty = cart.getItems().isEmpty();

        // Assert
        assertEquals(0.0, actualTotal, "The initial cart total must be 0.0");
        assertTrue(isListEmpty, "The initial ticket list must be empty");
    }
}