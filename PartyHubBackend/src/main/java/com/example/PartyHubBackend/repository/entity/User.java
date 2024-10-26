package com.example.PartyHubBackend.repository.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String username;
    private String email;
    private String password;

    @OneToMany(mappedBy = "organizer")
    private Set<Event> organizedEvents;

    @ManyToMany(mappedBy = "participants")
    private Set<Event> attendedEvents;

    public User() {
    }

    public User(String fullName, String username, String email, String password) {
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.password = password;
    }
}