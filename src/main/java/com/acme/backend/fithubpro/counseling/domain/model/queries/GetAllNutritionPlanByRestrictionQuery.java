package com.acme.backend.fithubpro.counseling.domain.model.queries;

public record GetAllNutritionPlanByRestrictionQuery(String restriction) {

        public GetAllNutritionPlanByRestrictionQuery {
            if (restriction == null || restriction.isBlank()) {
                throw new IllegalArgumentException("restriction cannot be null");
            }
        }
}
