package com.example.PartyHubBackend.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User assignedUser;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;


    public Task() {
    }


    public Task(String description, User assignedUser, Event event) {
        this.description = description;
        this.assignedUser = assignedUser;
        this.event = event;
    }
}
