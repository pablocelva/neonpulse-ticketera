package com.neonpulse.infrastructure.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.neonpulse.domain.entity.Concert;

@DisplayName("In-Memory Concert Repository (InMemoryConcertRepository)")
class InMemoryConcertRepositoryTest {

    @Test
    @DisplayName("Should save and find concert by ID successfully")
    void shouldSaveAndFindConcertById() {
        // Arrange
        InMemoryConcertRepository repository = new InMemoryConcertRepository();
        Concert concert = new Concert("C-001", "Rock Festival", "The Rollers", 75.0);

        // Act
        repository.save(concert);
        Optional<Concert> found = repository.findById("C-001");

        // Assert
        assertThat(found).isPresent();
        assertThat(found.get().getTitle()).isEqualTo("Rock Festival");
        assertThat(found.get().getBand()).isEqualTo("The Rollers");
        assertThat(found.get().getTicketPrice()).isEqualTo(75.0);
    }

    @Test
    @DisplayName("Should return empty optional when concert ID is not found")
    void shouldReturnEmptyOptionalWhenNotFound() {
        // Arrange
        InMemoryConcertRepository repository = new InMemoryConcertRepository();

        // Act
        Optional<Concert> found = repository.findById("NON-EXISTENT");

        // Assert
        assertThat(found).isEmpty();
    }
}