# ⏸️ MorphUp (On Hold)

MorphUp is a Spring Boot backend designed to deliver personalized workout recommendations based on a user's physical profile, available equipment, and training environment — with planned support for approximate sets/reps calculated from BMI.

Development is currently paused while I focus on interview prep, but I plan to pick this back up.

## Current Progress

- ✅ Project initialization & backend architecture planning
- ✅ PostgreSQL integration via Spring Data JPA (normalized schema: Users, Exercises, MuscleGroups, WorkoutSessions, SessionExercises)
- ✅ User registration — BCrypt password hashing, duplicate email/username validation, BMI auto-calculation from height/weight
- ✅ Core workout recommendation endpoint — filters exercises by target muscle group and user's available equipment
- 🚧 JWT authentication — dependencies and route rules in place, login/token flow not yet functional
- 🚧 Sets & reps calculation engine (BMI-based approximation)
- 🚧 Full REST API coverage
- 🚧 Frontend
- 🚧 Docker support
- 🚧 Documentation

## Planned

- Recommendations that adapt to workout environment (home/gym/limited equipment), not just muscle group + equipment
- BMI-driven approximate sets/reps suggestions per exercise
- Full-stack build out with a frontend client
