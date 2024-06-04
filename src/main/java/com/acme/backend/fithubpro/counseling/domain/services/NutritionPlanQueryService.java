package com.acme.backend.fithubpro.counseling.domain.services;

import com.acme.backend.fithubpro.counseling.domain.model.aggregate.NutritionPlan;
import com.acme.backend.fithubpro.counseling.domain.model.queries.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface NutritionPlanQueryService {
    List<NutritionPlan> handle(GetAllNutritionPlanByTitleQuery query);

    List<NutritionPlan> handle(GetAllNutritionPlanByGoalHealthQuery query);

    List<NutritionPlan> handle(GetAllNutritionPlanByRestrictionQuery query);

    List<NutritionPlan> handle(GetAllNutritionPlanByCaloriesQuery query);

    List<NutritionPlan> handle(GetAllNutritionPlanByIngredientsQuery query);

    List<NutritionPlan> handle(GetAllNutritionPlanByDescriptionQuery query);

    Optional<NutritionPlan> handle(GetNutritionPlanByTitleAndGoalHealthQuery query);

    Optional<NutritionPlan> handle(GetNutritionPlanByIdQuery query);
}
