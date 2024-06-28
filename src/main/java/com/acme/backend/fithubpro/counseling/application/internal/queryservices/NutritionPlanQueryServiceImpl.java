package com.acme.backend.fithubpro.counseling.application.internal.queryservices;

import com.acme.backend.fithubpro.counseling.domain.model.aggregate.NutritionPlan;
import com.acme.backend.fithubpro.counseling.domain.model.queries.*;
import com.acme.backend.fithubpro.counseling.domain.services.NutritionPlanQueryService;
import com.acme.backend.fithubpro.counseling.infraestructure.persistance.jpa.NutritionPlanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NutritionPlanQueryServiceImpl implements NutritionPlanQueryService {

    private final NutritionPlanRepository nutritionPlanRepository;

    public NutritionPlanQueryServiceImpl(NutritionPlanRepository nutritionPlanRepository) {
        this.nutritionPlanRepository = nutritionPlanRepository;
    }

    @Override
    public List<NutritionPlan> handle(GetAllNutritionPlanByTitleQuery query) {
        return nutritionPlanRepository.findAllByTitle(query.title());
    }

    @Override
    public List<NutritionPlan> handle(GetAllNutritionPlanByGoalHealthQuery query) {
        return nutritionPlanRepository.findAllByGoalHealth(query.goalHealth());
    }

    @Override
    public List<NutritionPlan> handle(GetAllNutritionPlanByRestrictionQuery query) {
        return nutritionPlanRepository.findAllByRestriction(query.restriction());
    }

    @Override
    public List<NutritionPlan> handle(GetAllNutritionPlanByCaloriesQuery query) {
        return nutritionPlanRepository.findAllByCalories(query.calories());
    }

    @Override
    public List<NutritionPlan> handle(GetAllNutritionPlanByIngredientsQuery query) {
        return nutritionPlanRepository.findAllByIngredients(query.ingredients());
    }

    @Override
    public List<NutritionPlan> handle(GetAllNutritionPlanByDescriptionQuery query) {
        return nutritionPlanRepository.findAllByDescription(query.description());
    }

    @Override
    public Optional<NutritionPlan> handle(GetNutritionPlanByTitleAndGoalHealthQuery query) {
        return nutritionPlanRepository.findByTitleAndGoalHealth(query.title(), query.goalHealth());
    }

    @Override
    public Optional<NutritionPlan> handle(GetNutritionPlanByIdQuery query) {
        return nutritionPlanRepository.findById(query.id());
    }

    @Override
    public List<NutritionPlan> getAllNutritionPlans() {
        return nutritionPlanRepository.findAll();
    }

    @Override
    public List<NutritionPlan> getNutritionPlansByCoachId(Long coachId) {
        return nutritionPlanRepository.findAllByCoachId(coachId);
    }
}
