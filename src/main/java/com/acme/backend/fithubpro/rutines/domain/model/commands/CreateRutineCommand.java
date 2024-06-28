package com.acme.backend.fithubpro.rutines.domain.model.commands;

public record CreateRutineCommand(String name, String exercise, String repetition, String photo, String instruction, Long coachId, Long memberId) {
    public CreateRutineCommand {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must not be null or empty.");
        }
        if (exercise == null || exercise.isBlank()) {
            throw new IllegalArgumentException("Exercise must not be null or empty.");
        }
        if (repetition == null || repetition.isBlank()) {
            throw new IllegalArgumentException("Repetition must not be null or empty.");
        }
        if (photo == null || photo.isBlank()) {
            throw new IllegalArgumentException("Photo must not be null or empty.");
        }
        if (instruction == null || instruction.isBlank()) {
            throw new IllegalArgumentException("Instruction must not be null or empty.");
        }
        if (coachId == null) {
            throw new IllegalArgumentException("CoachId must not be null.");
        }
    }
}
