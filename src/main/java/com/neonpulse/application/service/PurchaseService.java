package com.neonpulse.application.service;

import com.neonpulse.application.port.SmsNotifier;

public class PurchaseService {

    private final SmsNotifier notifier;

    public PurchaseService(SmsNotifier notifier) {
        this.notifier = notifier;
    }

    public void processPurchase(String phoneNumber, String content) {
        notifier.sendMessage(phoneNumber, content);
    }
}