package com.neonpulse.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Payment Service (PaymentService)")
public class PaymentServiceTest {

    @Test
    @DisplayName("Should fail when processing payment with an empty ticketId")
    public void shouldFailWhenProcessingPaymentWithEmptyTicketId() {
        // Arrange
        MessageNotifier notifierMock = mock(MessageNotifier.class);
        PaymentService paymentService = new PaymentService(notifierMock);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            paymentService.processPayment("", "123456789");
        }, "Should fail if ticketId is empty");
    }

    @Test
    @DisplayName("Should fail when processing payment with a null ticketId")
    public void shouldFailWhenProcessingPaymentWithNullTicketId() {
        // Arrange
        MessageNotifier notifierMock = mock(MessageNotifier.class);
        PaymentService paymentService = new PaymentService(notifierMock);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            paymentService.processPayment(null, "123456789");
        }, "Should fail if ticketId is null");
    }

    @Test
    @DisplayName("Should process payment successfully and send notification")
    public void shouldProcessPaymentSuccessfullyAndSendNotification() {
        // Arrange
        MessageNotifier notifierMock = mock(MessageNotifier.class);
        PaymentService paymentService = new PaymentService(notifierMock);

        // Act
        paymentService.processPayment("TICKET-001", "123456789");

        // Assert
        verify(notifierMock, times(1)).sendNotification("123456789", "Payment processed for ticket id: TICKET-001");
    }
}
