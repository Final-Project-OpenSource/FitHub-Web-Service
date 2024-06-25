package com.acme.backend.fithubpro.counseling.domain.services;

import com.acme.backend.fithubpro.counseling.domain.model.aggregate.NutritionPlan;
import com.acme.backend.fithubpro.counseling.domain.model.commands.CreateNutritionPlanCommand;
import java.util.Optional;

public interface NutritionPlanCommandService {
    Optional<NutritionPlan> handle(CreateNutritionPlanCommand command);
}