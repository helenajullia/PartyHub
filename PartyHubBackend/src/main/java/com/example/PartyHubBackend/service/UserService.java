package com.example.PartyHubBackend.service;



import com.example.PartyHubBackend.repository.dto.UserResponseDTO;
import com.example.PartyHubBackend.repository.dto.UserRequestDTO;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO userRequestDTO);
    UserResponseDTO getUserById(Long id);

    void registerUser(UserRequestDTO userRequestDTO);

}
