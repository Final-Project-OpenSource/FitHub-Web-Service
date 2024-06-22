package com.acme.backend.fithubpro.rutines.interfaces.rest.resources;

public record CreateRutinesREsource(String name, String exercise, String repetition, String photo, String instruction) {
    public CreateRutinesREsource{
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name must not be null or empty.");
        }
        if (exercise == null || exercise.isBlank()) {
            throw new IllegalArgumentException("exercise must not be null or empty.");
        }
        if (repetition == null || repetition.isBlank()) {
            throw new IllegalArgumentException("repetition must not be null or empty.");
        }
        if (photo == null || photo.isBlank()) {
            throw new IllegalArgumentException("photo must not be null or empty.");
        }
        if (instruction == null || instruction.isBlank()) {
            throw new IllegalArgumentException("instruction must not be null or empty.");
        }
    }
}
