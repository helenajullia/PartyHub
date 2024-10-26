package com.example.PartyHubBackend.repository.dto;


import lombok.Data;

@Data
public class UserResponseDTO {
    private Long id;
    private String fullName;
    private String username;
    private String email;
}

