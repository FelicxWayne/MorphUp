package com.morphup.service;

import com.morphup.model.Exercise;
import com.morphup.model.MuscleGroup;
import com.morphup.repository.ExerciseRepository;
import com.morphup.repository.MuscleGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkoutService {


    private final ExerciseRepository exerciseRepository;
    private final MuscleGroupRepository muscleGroupRepository;

    public List<Exercise> generateAdaptedWorkout(Long muscleGroupId, List<Exercise.EquipmentType> availableEquipment) {


        MuscleGroup targetMuscle = muscleGroupRepository.findById(muscleGroupId)
                .orElseThrow(() -> new IllegalArgumentException("Muscle group not found for ID: " + muscleGroupId));

        List<Exercise> adaptedExercises = exerciseRepository.findByMuscleGroupAndEquipmentTypeIn(targetMuscle, availableEquipment);

        return adaptedExercises;
    }
}
