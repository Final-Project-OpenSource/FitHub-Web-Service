package com.acme.backend.fithubpro.rutines.domain.model.commands;

public record CreateRutineCommand(String name, String exercise, String repetition, String photo, String instruction) {
    public CreateRutineCommand {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Title must not be null or empty.");
        }
        if (exercise == null || exercise.isBlank()) {
            throw new IllegalArgumentException("Photo must not be null or empty.");
        }
        if (repetition == null || repetition.isBlank()) {
            throw new IllegalArgumentException("Description must not be null or empty.");
        }
        if (photo == null || photo.isBlank()) {
            throw new IllegalArgumentException("Ingredients must not be null or empty.");
        }
        if (instruction == null || instruction.isBlank()) {
            throw new IllegalArgumentException("Calories must not be null or empty.");
        }
    }
}
