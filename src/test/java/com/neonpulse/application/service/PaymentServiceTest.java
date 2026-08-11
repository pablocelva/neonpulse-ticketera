package com.neonpulse.application.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.neonpulse.application.port.MessageNotifier;

@ExtendWith(MockitoExtension.class)
@DisplayName("Payment Service (PaymentService)")
class PaymentServiceTest {

    @Mock
    private MessageNotifier notifierMock;

    @InjectMocks
    private PaymentService paymentService;

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Should fail when processing payment with an empty or null ticketId")
    void shouldFailWhenProcessingPaymentWithEmptyOrNullTicketId(String invalidTicketId) {
        // Act & Assert
        assertThatThrownBy(() -> paymentService.processPayment(invalidTicketId, "123456789"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Should process payment successfully and send notification")
    void shouldProcessPaymentSuccessfullyAndSendNotification() {
        // Act
        paymentService.processPayment("TICKET-001", "123456789");

        // Assert
        verify(notifierMock, times(1)).sendNotification("123456789", "Payment processed for ticket id:TICKET-001");
    }
}