package com.acme.backend.fithubpro.counseling.domain.model.queries;

public record GetNutritionPlanByTitleAndGoalHealthQuery(String title, String goalHealth) {

        public GetNutritionPlanByTitleAndGoalHealthQuery {
            if (title == null || title.isBlank()) {
                throw new IllegalArgumentException("title cannot be null");
            }
            if (goalHealth == null || goalHealth.isBlank()) {
                throw new IllegalArgumentException("goalHealth cannot be null");
            }
        }
}
