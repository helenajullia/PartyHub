package com.example.PartyHubBackend.repository.dto;

import lombok.Data;

@Data
public class UserRequestDTO {
    private String fullName;
    private String username;
    private String email;
    private String password;
}
