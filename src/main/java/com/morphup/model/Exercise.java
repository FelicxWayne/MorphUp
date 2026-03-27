package com.morphup.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "exercises")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "muscle_group_id", nullable = false)
    private MuscleGroup muscleGroup;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "equipment_type", nullable = false)
    private EquipmentType equipmentType;

    @Column(columnDefinition = "TEXT")
    private String description;

    public enum EquipmentType{
        BODYWEIGHT,
        DUMBBELL,
        BARBELL,
        CABLE,
        MACHINE
    }
}
