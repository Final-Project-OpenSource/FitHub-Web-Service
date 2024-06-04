package com.acme.backend.fithubpro.counseling.application.internal.commandservices;

import com.acme.backend.fithubpro.counseling.domain.model.aggregate.NutritionPlan;
import com.acme.backend.fithubpro.counseling.domain.model.commands.CreateNutritionPlanCommand;
import com.acme.backend.fithubpro.counseling.domain.services.NutritionPlanCommandService;
import com.acme.backend.fithubpro.counseling.infraestructure.persistance.jpa.NutritionPlanRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NutritionPlanCommandServiceImpl implements NutritionPlanCommandService {

    private final NutritionPlanRepository nutritionPlanRepository;

    public NutritionPlanCommandServiceImpl(NutritionPlanRepository nutritionPlanRepository) {
        this.nutritionPlanRepository = nutritionPlanRepository;
    }
    /**
     * Handle the creation of a nutrition plan
     * @param command - The command to create a nutrition plan
     * @return an optional of the created nutrition plan
     */

    @Override
    public Optional<NutritionPlan> handle(CreateNutritionPlanCommand command) {
        if( nutritionPlanRepository.existsByTitleAndGoalHealth(command.title(), command.goalHealth())){
            throw new IllegalArgumentException("Nutrition plan with same title and goal health already exists");
        }
        var nutritionPlan = new NutritionPlan(command);
        var createdNutritionPlan = nutritionPlanRepository.save(nutritionPlan);
        return Optional.of(createdNutritionPlan);
    }
}
