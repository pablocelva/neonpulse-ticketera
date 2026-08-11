package com.neonpulse.domain.valueobject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.neonpulse.domain.exception.InvalidEmailException;

public class EmailTest {

  // Caso de exito
  @Test
  @DisplayName("Should create email instance when format is valid")
  public void shouldCreateEmailInstanceWhenFormatIsValid(){
    // Arrange
    String email = "username@mail.com";
    
    // Act
    Email emailInstance = new Email(email);
    
    // Assert
    assertNotNull(emailInstance);
    assertEquals("username@mail.com", emailInstance.value());
  }

  // Sanitización en el constructor
  @Test
  @DisplayName("Should trim and convert to lower case when creating email")
  public void shouldTrimAndConvertToLowerCase(){
    // Arrange
    String email = "  Username@Mail.Com  ";

    // Act
    Email emailInstance = new Email(email);

    // Assert
    assertNotNull(emailInstance);
    assertEquals("username@mail.com", emailInstance.value());
  }

  @Test
  @DisplayName("Should fail when email format is invalid")
  public void shouldFailWhenEmailFormatIsInvalid() {
    // Arrange
    String invalidEmail = "invalid-email";

    // Act & Assert
    assertThrows(InvalidEmailException.class, () -> {
      new Email(invalidEmail);
    });
  }
}