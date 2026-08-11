package com.neonpulse.application.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.neonpulse.application.service.ShoppingCart;

@DisplayName("Shopping Cart (ShoppingCart)")
class ShoppingCartTest {

    @Test
    @DisplayName("Should initialize cart with zero total and empty list")
    void shouldInitializeCartWithZeroTotalAndEmptyList() {
        // Arrange & Act
        ShoppingCart cart = new ShoppingCart();

        // Assert
        assertThat(cart.getTotal())
                .as("The initial cart total must be 0.0")
                .isEqualTo(0.0);
        assertThat(cart.getItems())
                .as("The initial ticket list must be empty")
                .isEmpty();
        assertThat(cart.getTotalItems())
                .as("The initial total items count must be 0")
                .isZero();
    }
}