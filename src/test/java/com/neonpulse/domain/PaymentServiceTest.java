package com.neonpulse.domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@DisplayName("Servicio de Pagos (PaymentService)")
public class PaymentServiceTest {
    private static class DummyNotifier implements MessageNotifier {
        @Override
        public void sendNotification(String destination, String Message) {
            // no se hace nada, es un cascaron
        }
    }

    @Test
    @DisplayName("Debe fallar al procesar pago con ticketId inválido")
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
