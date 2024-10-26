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

        // Conversie corectă pentru budget
        Double budget;
        Object budgetObj = eventData.get("budget");
        if (budgetObj instanceof Integer) {
            budget = ((Integer) budgetObj).doubleValue();
        } else if (budgetObj instanceof Double) {
            budget = (Double) budgetObj;
        } else {
            throw new IllegalArgumentException("Invalid budget format");
        }

        String dateString = (String) eventData.get("date");
        Long organizerId = Long.valueOf(eventData.get("organizer_id").toString());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date;
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format");
        }

        User organizer = userRepository.findById(organizerId)
                .orElseThrow(() -> new IllegalArgumentException("Organizer not found"));

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
}