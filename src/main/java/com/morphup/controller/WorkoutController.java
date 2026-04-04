package com.morphup.controller;

import com.morphup.model.Exercise;
import com.morphup.service.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/workouts")
@RequiredArgsConstructor
public class WorkoutController {

    private final WorkoutService workoutService;

    @GetMapping("/adapt")
    public List<Exercise> adaptWorkout(
            @RequestParam Long muscleGroupId,
            @RequestParam List<Exercise.EquipmentType> availableEquipment) {

        return workoutService.generateAdaptedWorkout(muscleGroupId, availableEquipment);
    }
}
