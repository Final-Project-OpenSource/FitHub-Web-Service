package com.acme.backend.fithubpro.rutines.domain.model.queries;

public record GetAllRutinesByexerciseQuery(String exercise) {
    public GetAllRutinesByexerciseQuery{
        if (exercise == null || exercise.isBlank()) {
            throw new IllegalArgumentException("exercise cannot be null");
        }
    }
}
