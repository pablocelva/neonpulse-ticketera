package com.neonpulse.application.usecase;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.neonpulse.domain.entity.Concert;
import com.neonpulse.domain.repository.ConcertRepository;

public class RegisterConcertUseCaseTest {
  
  @Test
  public void shouldRegisterConcertSuccessfullyWhenNotExists(){
    // Arrange: crear el mock de la interfaz de dominio
    ConcertRepository repositoryMock = Mockito.mock(ConcertRepository.class);
    RegisterConcertUseCase useCase = new RegisterConcertUseCase(repositoryMock);

    Concert concert = new Concert("ticket-0001", "The Beatles", "John Lennon", 100.0);

    when(repositoryMock.findById("ticket-0001")).thenReturn(Optional.empty());
    
    // Act
    useCase.execute(concert);

    // Assert
    verify(repositoryMock,times(1)).save(concert);
  }

  @Test
  public void shouldThrowExceptionWhenConcertAlreadyExists(){
    // Arrange: crear el mock de la interfaz de dominio
    ConcertRepository repositoryMock = Mockito.mock(ConcertRepository.class);
    RegisterConcertUseCase useCase = new RegisterConcertUseCase(repositoryMock);

    Concert concert = new Concert("ticket-0001", "The Beatles", "John Lennon", 100.0);

    when(repositoryMock.findById("ticket-0001")).thenReturn(Optional.of(concert));
    
    // Act & Assert
    assertThrows(IllegalArgumentException.class, () -> {
      useCase.execute(concert);
    });

    verify(repositoryMock, never()).save(any());

  }
}