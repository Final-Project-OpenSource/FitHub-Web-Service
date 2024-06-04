package com.acme.backend.fithubpro.counseling.interfaces.rest.transform;

import com.acme.backend.fithubpro.counseling.domain.model.aggregate.NutritionPlan;
import com.acme.backend.fithubpro.counseling.interfaces.rest.resources.NutritionPlanResource;

public class NutritionPlanResourceFromEntityAssembler {
    public static NutritionPlanResource toResourceFromEntity(NutritionPlan entity) {
        return new NutritionPlanResource(
            entity.getId(),
            entity.getTitle(),
            entity.getPhoto(),
            entity.getDescription(),
            entity.getIngredients(),
            entity.getCalories(),
            entity.getGoalHealth(),
            entity.getRestriction()
        );
    }
}
