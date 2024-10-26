package com.example.PartyHubBackend.service;



import com.example.PartyHubBackend.repository.dto.UserResponseDTO;
import com.example.PartyHubBackend.repository.dto.UserRequestDTO;
import com.example.PartyHubBackend.repository.entity.User;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO userRequestDTO);
    UserResponseDTO getUserById(Long id);

    User registerUser(UserRequestDTO userRequestDTO);

}
