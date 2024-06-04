package com.acme.backend.fithubpro.counseling.domain.model.queries;

public record GetAllNutritionPlanByIngredientsQuery(String ingredients) {

            public GetAllNutritionPlanByIngredientsQuery {
                if (ingredients == null || ingredients.isBlank()) {
                    throw new IllegalArgumentException("ingredients cannot be null");
                }
            }
}
