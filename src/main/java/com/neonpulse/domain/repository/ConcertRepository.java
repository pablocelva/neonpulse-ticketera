package com.neonpulse.domain.repository;

import java.util.Optional;

import com.neonpulse.domain.entity.Concert;

public interface ConcertRepository {
  void save(Concert concert);
  Optional<Concert> findById(String id);
}