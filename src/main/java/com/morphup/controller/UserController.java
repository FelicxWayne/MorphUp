package com.morphup.controller;

import com.morphup.dto.UserRegistrationDto;
import com.morphup.dto.UserResponseDto;
import com.morphup.model.User;
import com.morphup.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(@RequestBody UserRegistrationDto requestDto) {

        UserResponseDto response = userService.registerUser(requestDto);

        return ResponseEntity.ok(response);
    }
}