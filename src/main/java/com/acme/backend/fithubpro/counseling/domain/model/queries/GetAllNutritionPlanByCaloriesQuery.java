package com.acme.backend.fithubpro.counseling.domain.model.queries;

public record GetAllNutritionPlanByCaloriesQuery(String calories) {

        public GetAllNutritionPlanByCaloriesQuery {
            if (calories == null || calories.isBlank()) {
                throw new IllegalArgumentException("calories cannot be null");
            }
        }
}
