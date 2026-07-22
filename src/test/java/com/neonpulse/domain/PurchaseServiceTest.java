package com.neonpulse.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
    
@DisplayName("Servicio de Compras (PurchaseService)")
public class PurchaseServiceTest {
    @Test
    @DisplayName("Debe invocar al notificador exactamente una vez tras una compra exitosa")
    public void shoulInvokeNotifierExactlyOnceUponSuccessfulPurchase() {
        // Arrange
        SmsNotifier notifierMock = Mockito.mock(SmsNotifier.class);
        PurchaseService purchaseService = new PurchaseService(notifierMock);

        // Act
        purchaseService.processPurchase("+56912341234", "Ticket 01");

        // Assert
        Mockito.verify(notifierMock, Mockito.times(1)).sendMessage("+56912341234", "Ticket 01");
    }
}