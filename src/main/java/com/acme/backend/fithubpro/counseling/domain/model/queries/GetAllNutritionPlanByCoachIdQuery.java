package com.acme.backend.fithubpro.counseling.domain.model.queries;

public record GetAllNutritionPlanByCoachIdQuery(Integer coachId) {
    public GetAllNutritionPlanByCoachIdQuery {
        if (coachId == null) {
            throw new IllegalArgumentException("Coach ID cannot be null");
        }
    }
}
