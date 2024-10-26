package com.example.PartyHubBackend.service.implementation;

import com.example.PartyHubBackend.repository.dto.UserResponseDTO;
import com.example.PartyHubBackend.repository.dto.UserRequestDTO;
import com.example.PartyHubBackend.repository.entity.User;
import com.example.PartyHubBackend.repository.UserRepository;
import com.example.PartyHubBackend.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setFullName(userRequestDTO.getFullName());
        user.setUsername(userRequestDTO.getUsername());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());
        user = userRepository.save(user);

        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setId(user.getId());
        responseDTO.setFullName(user.getFullName());
        responseDTO.setUsername(user.getUsername());
        responseDTO.setEmail(user.getEmail());

        return responseDTO;
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setId(user.getId());
        responseDTO.setFullName(user.getFullName());
        responseDTO.setUsername(user.getUsername());
        responseDTO.setEmail(user.getEmail());
        return responseDTO;
    }

    @Override
    public User registerUser(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setFullName(userRequestDTO.getFullName());
        user.setUsername(userRequestDTO.getUsername());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());

        // Salvează utilizatorul în baza de date
        return userRepository.save(user); // returnează obiectul salvat
    }
}
