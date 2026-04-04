package com.morphup.config;

import com.morphup.model.Exercise;
import com.morphup.model.MuscleGroup;
import com.morphup.repository.ExerciseRepository;
import com.morphup.repository.MuscleGroupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final MuscleGroupRepository muscleGroupRepository;
    private final ExerciseRepository exerciseRepository;

    @Override
    public void run(String... args) throws Exception {

        if (muscleGroupRepository.count() == 0) {
            log.info("🌱 Seeding database with VoidFit starter data...");

            MuscleGroup chest = new MuscleGroup();
            chest.setName("Chest");

            MuscleGroup legs = new MuscleGroup();
            legs.setName("Legs");

            chest = muscleGroupRepository.save(chest);
            legs = muscleGroupRepository.save(legs);

            Exercise pushups = new Exercise();
            pushups.setName("Push-ups");
            pushups.setMuscleGroup(chest);
            pushups.setEquipmentType(Exercise.EquipmentType.BODYWEIGHT);

            Exercise benchPress = new Exercise();
            benchPress.setName("Barbell Bench Press");
            benchPress.setMuscleGroup(chest);
            benchPress.setEquipmentType(Exercise.EquipmentType.MACHINE); // Assuming barbell is grouped here or add BARBELL to your Enum!

            Exercise dbPress = new Exercise();
            dbPress.setName("Dumbbell Chest Press");
            dbPress.setMuscleGroup(chest);
            dbPress.setEquipmentType(Exercise.EquipmentType.DUMBBELL);

            Exercise squats = new Exercise();
            squats.setName("Bodyweight Squats");
            squats.setMuscleGroup(legs);
            squats.setEquipmentType(Exercise.EquipmentType.BODYWEIGHT);

            exerciseRepository.saveAll(List.of(pushups, benchPress, dbPress, squats));

            log.info("✅ Database seeded successfully! Engine is ready.");
        }
    }
}
