package com.example.PartyHubBackend.service;

import com.example.PartyHubBackend.repository.entity.Event;
import java.util.List;
import java.util.Map;

public interface EventService {

    void createEvent(Map<String, Object> eventData);


    List<Event> getAllEvents();

    Event getEventById(Long id);

    void deleteEvent(Long id);

    List<Event> getEventsByUserId(Long userId);
}
