package com.neonpulse.domain.service;

import com.neonpulse.domain.exception.OutOfStockException;

public class StockManager {

    public void checkAvailability(int stock, int quantity) {
        if (stock < quantity) {
            throw new OutOfStockException(
                "Operation rejected: Insufficient stock."
            );
        }
    }
}