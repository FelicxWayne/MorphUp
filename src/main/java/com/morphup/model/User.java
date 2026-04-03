package com.morphup.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @ElementCollection(targetClass = Exercise.EquipmentType.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_equipment_preferences", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "equipment_type")
    private Set<Exercise.EquipmentType> equipmentPreferences = new HashSet<>();

    @Column(name = "height_cm")
    private Float heightCm;

    @Column(name = "weight_kg")
    private Float weightKg;

    @Transient
    public Float getBmi() {
        if (heightCm != null && weightKg != null && heightCm > 0) {
            float heightMeters = heightCm / 100;
            return weightKg / (heightMeters * heightMeters);
        }
        return null;
    }

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}
