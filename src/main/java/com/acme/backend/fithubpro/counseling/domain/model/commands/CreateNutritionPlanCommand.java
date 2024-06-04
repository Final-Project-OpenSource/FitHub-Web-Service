package com.acme.backend.fithubpro.counseling.domain.model.commands;

public record CreateNutritionPlanCommand(String title, String photo, String description, String ingredients, String calories, String goalHealth, String restriction) {

    public CreateNutritionPlanCommand {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title must not be null or empty.");
        }
        if (photo == null || photo.isBlank()) {
            throw new IllegalArgumentException("Photo must not be null or empty.");
        }
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description must not be null or empty.");
        }
        if (ingredients == null || ingredients.isBlank()) {
            throw new IllegalArgumentException("Ingredients must not be null or empty.");
        }
        if (calories == null || calories.isBlank()) {
            throw new IllegalArgumentException("Calories must not be null or empty.");
        }
        if (goalHealth == null || goalHealth.isBlank()) {
            throw new IllegalArgumentException("Goal health must not be null or empty.");
        }
        if (restriction == null || restriction.isBlank()) {
            throw new IllegalArgumentException("Restriction must not be null or empty.");
        }
    }
}
