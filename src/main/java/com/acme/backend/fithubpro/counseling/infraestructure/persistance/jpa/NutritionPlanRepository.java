package com.acme.backend.fithubpro.counseling.infraestructure.persistance.jpa;

import com.acme.backend.fithubpro.counseling.domain.model.aggregate.NutritionPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NutritionPlanRepository extends JpaRepository<NutritionPlan, Long> {

    List<NutritionPlan> findAllByTitle(String title);
    List<NutritionPlan> findAllByGoalHealth(String goalHealth);
    List<NutritionPlan> findAllByRestriction(String restriction);
    List<NutritionPlan> findAllByCalories(String calories);
    List<NutritionPlan> findAllByIngredients(String ingredients);
    List<NutritionPlan> findAllByDescription(String description);
    List<NutritionPlan> findAllByCoachId(Long coachId);
    boolean existsByTitleAndGoalHealth(String title, String goalHealth);
    Optional<NutritionPlan> findByTitleAndGoalHealth(String title, String goalHealth);
}
