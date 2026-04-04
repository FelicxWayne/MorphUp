package com.morphup.service;

import com.morphup.dto.UserRegistrationDto;
import com.morphup.dto.UserResponseDto;
import com.morphup.model.User;
import com.morphup.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserResponseDto registerUser(UserRegistrationDto dto){
        if(userRepository.findByEmail(dto.getEmail()).isPresent()){
            throw new IllegalArgumentException("This Email is Already in Use");
        }
        if(userRepository.findByUsername(dto.getUsername()).isPresent()){
            throw new IllegalArgumentException("Username has already been taken");
        }

        User newUser = new User();
        newUser.setEmail(dto.getEmail());
        newUser.setUsername(dto.getUsername());
        newUser.setPassword(passwordEncoder.encode(dto.getPassword()));
        newUser.setEquipmentPreferences(dto.getEquipmentPreferences());
        newUser.setHeightCm(dto.getHeightCm());
        newUser.setWeightKg(dto.getWeightKg());

        User savedUser = userRepository.save(newUser);

        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(savedUser.getId());
        responseDto.setUsername(savedUser.getUsername());
        responseDto.setEmail(savedUser.getEmail());
        responseDto.setEquipmentPreferences(savedUser.getEquipmentPreferences());
        responseDto.setHeightCm(savedUser.getHeightCm());
        responseDto.setWeightKg(savedUser.getWeightKg());
        responseDto.setBmi(savedUser.getBmi());

        return responseDto;
    }
}
