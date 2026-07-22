package com.neonpulse.domain;

import com.neonpulse.domain.SmsNotifier;

public class PurchaseService {
    private final SmsNotifier notifier;

    public PurchaseService(SmsNotifier notifier) {
        this.notifier = notifier;
    }

    public void processPurchase(String phoneNumber, String content) {
        notifier.sendMessage(phoneNumber, content);
    }
}