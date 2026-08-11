package com.neonpulse.application.service;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    // Definir los valores iniciales
    private double total = 0.0;
    private List<Object> items = new ArrayList<>();

    public double getTotal() {
        return this.total;
    }

    public List<Object> getItems() {
        return this.items;
    }

    public int getTotalItems() {
        return this.items.size();
    }
}