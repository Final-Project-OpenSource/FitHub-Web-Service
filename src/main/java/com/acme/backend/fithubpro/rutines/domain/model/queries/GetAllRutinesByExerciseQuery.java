package com.acme.backend.fithubpro.rutines.domain.model.queries;

public record GetAllRutinesByExerciseQuery(String exercise) {
    public GetAllRutinesByExerciseQuery {
        if (exercise == null || exercise.isBlank()) {
            throw new IllegalArgumentException("exercise cannot be null");
        }
    }
}
