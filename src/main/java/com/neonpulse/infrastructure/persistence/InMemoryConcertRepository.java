package com.neonpulse.infrastructure.persistence;

import com.neonpulse.domain.entity.Concert;
import com.neonpulse.domain.repository.ConcertRepository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryConcertRepository implements ConcertRepository {

    private final Map<String, Concert> storage = new ConcurrentHashMap<>();

    @Override
    public void save(Concert concert) {
        if (concert != null && concert.getId() != null) {
            storage.put(concert.getId(), concert);
        }
    }

    @Override
    public Optional<Concert> findById(String id) {
        return Optional.ofNullable(storage.get(id));
    }
}