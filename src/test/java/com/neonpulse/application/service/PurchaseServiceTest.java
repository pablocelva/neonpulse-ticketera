package com.neonpulse.application.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.neonpulse.application.port.SmsNotifier;

@ExtendWith(MockitoExtension.class)
@DisplayName("Purchase Service (PurchaseService)")
class PurchaseServiceTest {

  @Mock
  private SmsNotifier notifierMock;

  @InjectMocks
  private PurchaseService purchaseService;

  @Test
  @DisplayName("Should invoke notifier exactly once upon successful purchase")
  void shouldInvokeNotifierExactlyOnceUponSuccessfulPurchase() {
    // Act
    purchaseService.processPurchase("+56912341234", "Ticket 01");

    // Assert
    verify(notifierMock, times(1)).sendMessage("+56912341234", "Ticket 01");
  }
}