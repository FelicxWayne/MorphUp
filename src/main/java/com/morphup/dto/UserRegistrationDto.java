package com.morphup.dto;

import com.morphup.model.Exercise;
import lombok.Data;
import java.util.Set;

@Data
public class UserRegistrationDto {
    private String username;
    private String email;
    private String password;
    private Set<Exercise.EquipmentType> equipmentPreferences;
    private Float heightCm;
    private Float weightKg;
}
