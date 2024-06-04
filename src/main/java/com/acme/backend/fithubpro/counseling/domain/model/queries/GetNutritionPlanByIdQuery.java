package com.acme.backend.fithubpro.counseling.domain.model.queries;

public record GetNutritionPlanByIdQuery(Long id) {

        public GetNutritionPlanByIdQuery {
            if (id == null) {
                throw new IllegalArgumentException("id cannot be null");
            }
        }
}
