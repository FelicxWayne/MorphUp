package com.morphup.repository;

import com.morphup.model.Exercise;
import com.morphup.model.MuscleGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {


    List<Exercise> findByMuscleGroupAndEquipmentTypeIn(MuscleGroup muscleGroup, List<Exercise.EquipmentType> equipmentTypes);

}
