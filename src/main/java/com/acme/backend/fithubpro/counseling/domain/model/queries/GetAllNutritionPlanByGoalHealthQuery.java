package com.acme.backend.fithubpro.counseling.domain.model.queries;

public record GetAllNutritionPlanByGoalHealthQuery(String goalHealth) {

    public GetAllNutritionPlanByGoalHealthQuery {
        if (goalHealth == null || goalHealth.isBlank()) {
            throw new IllegalArgumentException("goalHealth cannot be null");
        }
    }
}
