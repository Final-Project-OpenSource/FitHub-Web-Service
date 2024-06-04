package com.acme.backend.fithubpro.counseling.domain.model.queries;

public record GetAllNutritionPlanByDescriptionQuery(String description) {

        public GetAllNutritionPlanByDescriptionQuery {
            if (description == null || description.isBlank()) {
                throw new IllegalArgumentException("description cannot be null");
            }
        }
}
