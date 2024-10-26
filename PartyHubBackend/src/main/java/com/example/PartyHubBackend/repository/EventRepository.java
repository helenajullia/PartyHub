package com.example.PartyHubBackend.repository;

import com.example.PartyHubBackend.repository.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
