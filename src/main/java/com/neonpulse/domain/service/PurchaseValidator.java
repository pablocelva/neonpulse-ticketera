package com.neonpulse.domain.service;

import com.neonpulse.domain.exception.InvalidQuantityException;

public class PurchaseValidator {

    public void processQuantity(int quantity){
        if(quantity <= 0){
            throw new InvalidQuantityException();
        }
        //procesar la cantidad de entradas
    }

}