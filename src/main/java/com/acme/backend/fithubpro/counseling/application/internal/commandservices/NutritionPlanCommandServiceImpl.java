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

    @Override
    public Optional<NutritionPlan> handle(CreateNutritionPlanCommand command) {
        if (nutritionPlanRepository.existsByTitleAndGoalHealth(command.title(), command.goalHealth())) {
            throw new IllegalArgumentException("Nutrition plan with same title and goal health already exists");
        }
        NutritionPlan nutritionPlan = new NutritionPlan(command);
        NutritionPlan createdNutritionPlan = nutritionPlanRepository.save(nutritionPlan);
        return Optional.of(createdNutritionPlan);
    }

    @Override
    public Optional<NutritionPlan> update(Long id, CreateNutritionPlanCommand command) {
        Optional<NutritionPlan> existingNutritionPlan = nutritionPlanRepository.findById(id);
        if (existingNutritionPlan.isPresent()) {
            NutritionPlan nutritionPlan = existingNutritionPlan.get();
            nutritionPlan.setTitle(command.title());
            nutritionPlan.setPhoto(command.photo());
            nutritionPlan.setDescription(command.description());
            nutritionPlan.setIngredients(command.ingredients());
            nutritionPlan.setCalories(command.calories());
            nutritionPlan.setRestriction(command.restriction());
            nutritionPlan.setGoalHealth(command.goalHealth());
            nutritionPlan.setCoachId(command.coachId());
            nutritionPlan.setMemberId(command.memberId());
            return Optional.of(nutritionPlanRepository.save(nutritionPlan));
        }
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        nutritionPlanRepository.deleteById(id);
    }
}
