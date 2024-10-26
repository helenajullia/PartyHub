package com.example.PartyHubBackend.utils;

import com.example.PartyHubBackend.repository.entity.Event;
import com.example.PartyHubBackend.repository.entity.Task;
import com.example.PartyHubBackend.repository.entity.User;
import com.example.PartyHubBackend.repository.EventRepository;
import com.example.PartyHubBackend.repository.TaskRepository;
import com.example.PartyHubBackend.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Component
public class InitialDataLoader {

    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    private final TaskRepository taskRepository;

    public InitialDataLoader(UserRepository userRepository, EventRepository eventRepository, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
        this.taskRepository = taskRepository;
    }

    @PostConstruct
    public void loadData() {
        User alice = new User("Alice Johnson", "alice_j", "alice@example.com", "password123");
        User bob = new User("Bob Smith", "bob_s", "bob@example.com", "password123");
        User charlie = new User("Charlie Brown", "charlie_b", "charlie@example.com", "password123");
        User diana = new User("Diana Prince", "diana_p", "diana@example.com", "password123");
        User eve = new User("Eve Adams", "eve_a", "eve@example.com", "password123");
        User frank = new User("Frank Wright", "frank_w", "frank@example.com", "password123");
        User grace = new User("Grace Lee", "grace_l", "grace@example.com", "password123");
        User hank = new User("Hank Morgan", "hank_m", "hank@example.com", "password123");
        User irene = new User("Irene Gray", "irene_g", "irene@example.com", "password123");
        User jack = new User("Jack White", "jack_w", "jack@example.com", "password123");

        userRepository.save(alice);
        userRepository.save(bob);
        userRepository.save(charlie);
        userRepository.save(diana);
        userRepository.save(eve);
        userRepository.save(frank);
        userRepository.save(grace);
        userRepository.save(hank);
        userRepository.save(irene);
        userRepository.save(jack);

        Event event1 = new Event();
        event1.setName("Alice's Birthday Bash");
        event1.setDate(new Date());
        event1.setLocation("Alice's House");
        event1.setBudget(200.0);
        event1.setOrganizer(alice);

        Set<User> participants1 = new HashSet<>(Set.of(bob, charlie, diana));
        event1.setParticipants(participants1);
        eventRepository.save(event1);

        taskRepository.save(new Task("Bring drinks", bob, event1));
        taskRepository.save(new Task("Bring snacks", charlie, event1));
        taskRepository.save(new Task("Decorate the house", diana, event1));

        Event event2 = new Event();
        event2.setName("Bob's Themed Party");
        event2.setDate(new Date());
        event2.setLocation("Bob's Apartment");
        event2.setBudget(300.0);
        event2.setOrganizer(bob);

        Set<User> participants2 = new HashSet<>(Set.of(alice, eve, frank, grace));
        event2.setParticipants(participants2);
        eventRepository.save(event2);

        taskRepository.save(new Task("Set up the theme decorations", alice, event2));
        taskRepository.save(new Task("Bring pizza", eve, event2));
        taskRepository.save(new Task("Organize music playlist", frank, event2));
        taskRepository.save(new Task("Manage the games", grace, event2));

        Event event3 = new Event();
        event3.setName("Charlie's Halloween Night");
        event3.setDate(new Date());
        event3.setLocation("Charlie's Garden");
        event3.setBudget(400.0);
        event3.setOrganizer(charlie);

        Set<User> participants3 = new HashSet<>(Set.of(bob, diana, hank, irene, jack));
        event3.setParticipants(participants3);
        eventRepository.save(event3);

        taskRepository.save(new Task("Bring costumes", bob, event3));
        taskRepository.save(new Task("Set up spooky decorations", diana, event3));
        taskRepository.save(new Task("Prepare horror movie playlist", hank, event3));
        taskRepository.save(new Task("Bake Halloween treats", irene, event3));
        taskRepository.save(new Task("Handle the lighting setup", jack, event3));

        Event event4 = new Event();
        event4.setName("Diana's Christmas Party");
        event4.setDate(new Date());
        event4.setLocation("Diana's Place");
        event4.setBudget(500.0);
        event4.setOrganizer(diana);

        Set<User> participants4 = new HashSet<>(Set.of(alice, charlie, eve, frank, grace, hank));
        event4.setParticipants(participants4);
        eventRepository.save(event4);

        taskRepository.save(new Task("Bring holiday decorations", alice, event4));
        taskRepository.save(new Task("Organize Secret Santa", charlie, event4));
        taskRepository.save(new Task("Cook traditional dishes", eve, event4));
        taskRepository.save(new Task("Prepare drinks", frank, event4));
        taskRepository.save(new Task("Set up the Christmas tree", grace, event4));
        taskRepository.save(new Task("Prepare a Christmas music playlist", hank, event4));

        Event event5 = new Event();
        event5.setName("New Year's Eve Celebration");
        event5.setDate(new Date());
        event5.setLocation("Eve's Penthouse");
        event5.setBudget(1000.0);
        event5.setOrganizer(eve);

        Set<User> participants5 = new HashSet<>(Set.of(alice, bob, charlie, diana, frank, grace, hank, irene, jack));
        event5.setParticipants(participants5);
        eventRepository.save(event5);

        taskRepository.save(new Task("Arrange fireworks", alice, event5));
        taskRepository.save(new Task("Prepare champagne", bob, event5));
        taskRepository.save(new Task("Organize photo booth", charlie, event5));
        taskRepository.save(new Task("Setup lighting for dance floor", diana, event5));
        taskRepository.save(new Task("Prepare appetizers", frank, event5));
        taskRepository.save(new Task("Manage the sound system", grace, event5));
        taskRepository.save(new Task("Coordinate the countdown", hank, event5));
        taskRepository.save(new Task("Handle security arrangements", irene, event5));
        taskRepository.save(new Task("Set up decorations", jack, event5));
    }
}
