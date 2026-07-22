package com.neonpulse.domain;

import com.neonpulse.domain.exception.InvalidQuantityException;

public class PurchaseValidator {
    public void processQuantity(int quantity) {
        if (quantity <= 0) {
            throw new InvalidQuantityException();
        }
        // Procesar la cantidad de entradas
    }
}