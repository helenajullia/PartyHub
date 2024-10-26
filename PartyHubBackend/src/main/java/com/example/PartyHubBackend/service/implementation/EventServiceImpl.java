package com.example.PartyHubBackend.service.implementation;

import com.example.PartyHubBackend.repository.UserRepository;
import com.example.PartyHubBackend.repository.entity.Event;
import com.example.PartyHubBackend.repository.EventRepository;
import com.example.PartyHubBackend.repository.entity.User;
import com.example.PartyHubBackend.service.EventService;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public EventServiceImpl(EventRepository eventRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository=userRepository;
    }

    public void createEvent(Map<String, Object> eventData) {
        String name = (String) eventData.get("name");
        String location = (String) eventData.get("location");
        Double budget = Double.parseDouble(eventData.get("budget").toString());
        String dateString = (String) eventData.get("date");
        Long organizerId = Long.valueOf(eventData.get("organizer_id").toString());
        String organizerUsername = (String) eventData.get("organizer_username");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date;
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format");
        }

        User organizer = userRepository.findById(organizerId)
                .orElseThrow(() -> new IllegalArgumentException("Organizer not found"));

        // Verifică dacă username-ul se potrivește cu userId-ul
        if (!organizer.getUsername().equals(organizerUsername)) {
            throw new IllegalArgumentException("Username and ID do not match");
        }

        Event event = new Event();
        event.setName(name);
        event.setLocation(location);
        event.setBudget(budget);
        event.setDate(date);
        event.setOrganizer(organizer);

        eventRepository.save(event);
    }


    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    public List<Event> getEventsByUserId(Long userId) {
        return eventRepository.findByOrganizerId(userId);
    }
}