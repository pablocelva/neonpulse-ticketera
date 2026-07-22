package com.neonpulse.domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PaymentServiceTest {
    private static class DummyNotifier implements MessageNotifier {
        @Override
        public void sendNotification(String destination, String Message) {
            // no se hace nada, es un cascaron
        }
    }

    @Test
    public void shouldFailWhenProcessingPaymentWithInvalidTicketId() {
        // Arrange
        MessageNotifier dummyNotifier = new DummyNotifier();
        PaymentService paymentService = new PaymentService(dummyNotifier);

        // Act & Arrange
        assertThrows(IllegalArgumentException.class, () -> {
            paymentService.processPayment("", "123");
        }, "Debería fallar si el ticketId es incorrecto");
    }
}
