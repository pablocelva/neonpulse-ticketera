package com.neonpulse.domain;

public class PaymentService {
    private final MessageNotifier messageNotifier;

    public PaymentService(MessageNotifier messageNotifier) {
        this.messageNotifier = messageNotifier;
    }

    public void processPayment(String ticketId, String customerPhone) {
        if (ticketId == null || ticketId.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid ticketId");
        }
        this.messageNotifier.sendNotification(customerPhone, "Payment processed for ticket id: " + ticketId);
    }
}