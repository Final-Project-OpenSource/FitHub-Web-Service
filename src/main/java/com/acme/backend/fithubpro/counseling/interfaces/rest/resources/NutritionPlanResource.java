package com.acme.backend.fithubpro.counseling.interfaces.rest.resources;

public record NutritionPlanResource(Long id, String title, String photo, String description, String ingredients, String calories, String goalHealth, String restriction) {
}
