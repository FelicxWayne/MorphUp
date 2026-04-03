package com.morphup.service;

import com.morphup.dto.UserRegistrationDto;
import com.morphup.model.User;
import com.morphup.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User registerUser(UserRegistrationDto dto){
        if(userRepository.findByEmail(dto.getEmail()).isPresent()){
            throw new IllegalArgumentException("This Email is Already in Use");
        }
        if(userRepository.findByUsername(dto.getUsername()).isPresent()){
            throw new IllegalArgumentException("Username has already been taken");
        }

        User newUser = new User();
        newUser.setEmail(dto.getEmail());
        newUser.setUsername(dto.getUsername());

        //leaving a reminder for myself for encrypting the pass using BCrypt

        newUser.setPassword(dto.getPassword());

        newUser.setEquipmentPreferences(dto.getEquipmentPreferences());
        newUser.setHeightCm(dto.getHeightCm());
        newUser.setWeightKg(dto.getWeightKg());

        return userRepository.save(newUser);
    }
}
