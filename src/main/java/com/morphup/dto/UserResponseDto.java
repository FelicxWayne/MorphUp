package com.morphup.dto;

import com.morphup.model.Exercise;
import java.util.*;
import lombok.Data;

@Data
public class UserResponseDto {
    private Long id;
    private String username;
    private String email;
    private Set<Exercise.EquipmentType> equipmentPreferences;
    private Float heightCm;
    private Float weightKg;
    private Float bmi;
}