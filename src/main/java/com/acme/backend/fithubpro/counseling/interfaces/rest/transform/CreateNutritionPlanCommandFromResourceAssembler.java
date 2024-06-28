package com.acme.backend.fithubpro.counseling.interfaces.rest.transform;

import com.acme.backend.fithubpro.counseling.domain.model.commands.CreateNutritionPlanCommand;
import com.acme.backend.fithubpro.counseling.interfaces.rest.resources.CreateNutritionPlanResource;

public class CreateNutritionPlanCommandFromResourceAssembler {
    public static CreateNutritionPlanCommand toCommandFromResource(CreateNutritionPlanResource resource) {
        return new CreateNutritionPlanCommand(resource.title(), resource.photo(), resource.description(), resource.ingredients(), resource.calories(), resource.goalHealth(), resource.restriction(), resource.coachId(), resource.memberId());
    }
}
