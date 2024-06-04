package com.acme.backend.fithubpro.counseling.domain.model.queries;

public record GetAllNutritionPlanByTitleQuery(String title) {

    public GetAllNutritionPlanByTitleQuery {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title cannot be null");
        }
    }
}
