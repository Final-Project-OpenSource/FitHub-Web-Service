package com.acme.backend.fithubpro.counseling.interfaces.rest.controller;

import com.acme.backend.fithubpro.counseling.domain.model.aggregate.NutritionPlan;
import com.acme.backend.fithubpro.counseling.domain.model.queries.*;
import com.acme.backend.fithubpro.counseling.domain.services.NutritionPlanCommandService;
import com.acme.backend.fithubpro.counseling.domain.services.NutritionPlanQueryService;
import com.acme.backend.fithubpro.counseling.interfaces.rest.resources.CreateNutritionPlanResource;
import com.acme.backend.fithubpro.counseling.interfaces.rest.resources.NutritionPlanResource;
import com.acme.backend.fithubpro.counseling.interfaces.rest.transform.CreateNutritionPlanCommandFromResourceAssembler;
import com.acme.backend.fithubpro.counseling.interfaces.rest.transform.NutritionPlanResourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("api/v1/nutrition-plans")
public class NutritionPlanController {

    private final NutritionPlanCommandService nutritionPlanCommandService;
    private final NutritionPlanQueryService nutritionPlanQueryService;

    public NutritionPlanController(NutritionPlanQueryService nutritionPlanQueryService, NutritionPlanCommandService nutritionPlanCommandService) {
        this.nutritionPlanCommandService = nutritionPlanCommandService;
        this.nutritionPlanQueryService = nutritionPlanQueryService;
    }
    /**
     * Create a nutrition plan
     * @param resource - The nutrition plan to create
     * @return a response entity with the created nutrition plan
     */

    @PostMapping
    public ResponseEntity<NutritionPlanResource> createNutritionPlan(@RequestBody CreateNutritionPlanResource resource) {
        Optional<NutritionPlan> nutritionPlan = nutritionPlanCommandService.handle(CreateNutritionPlanCommandFromResourceAssembler.toCommandFromResource(resource));
        return nutritionPlan.map(source ->
                new ResponseEntity<>(NutritionPlanResourceFromEntityAssembler.toResourceFromEntity(source), CREATED)).orElseGet(() -> ResponseEntity.badRequest().build());
    }
    /**
     * Get a nutrition plan by ID
     * @param id - The ID of the nutrition plan
     * @return a response entity with the nutrition plan
     */
    @GetMapping("{id}")
    public ResponseEntity<NutritionPlanResource> getNutritionPlanById(@PathVariable Long id) {
        Optional<NutritionPlan> nutritionPlan = nutritionPlanQueryService.handle(new GetNutritionPlanByIdQuery(id));
        return nutritionPlan.map(source -> ResponseEntity.ok(NutritionPlanResourceFromEntityAssembler.toResourceFromEntity(source))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Get all nutrition plans by nutrition plan
     * @param nutritionPlans - the nutrition plan
     * @return a response entity with the nutrition plans
     */
    private ResponseEntity<List<NutritionPlanResource>> buildResponse(List<NutritionPlan> nutritionPlans) {
        if (nutritionPlans.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var nutritionPlanResources = nutritionPlans.stream()
                .map(NutritionPlanResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(nutritionPlanResources);
    }
    /**
     * Get all nutrition plans by title
     * @param title - The title of the nutrition plan
     * @return a response entity with the nutrition plans
     */
    private ResponseEntity<List<NutritionPlanResource>> getAllNutritionPlanByTitle(String title) {
        var getAllNutritionPlanByTitleQuery = new GetAllNutritionPlanByTitleQuery(title);
        var nutritionPlan = nutritionPlanQueryService.handle(getAllNutritionPlanByTitleQuery);
        return buildResponse(nutritionPlan);
    }
    /**
     * Get all nutrition plans by goal health
     * @param goalHealth - The goal health of the nutrition plan
     * @return a response entity with the nutrition plans
     */
    private ResponseEntity<List<NutritionPlanResource>> getAllNutritionPlanByGoalHealth(String goalHealth) {
        var getAllNutritionPlanByGoalHealthQuery = new GetAllNutritionPlanByGoalHealthQuery(goalHealth);
        var nutritionPlan = nutritionPlanQueryService.handle(getAllNutritionPlanByGoalHealthQuery);
        return buildResponse(nutritionPlan);
    }
    /**
     * Get all nutrition plans by restriction
     * @param restriction - The restriction of the nutrition plan
     * @return a response entity with the nutrition plans
     */
    private ResponseEntity<List<NutritionPlanResource>> getAllNutritionPlanByRestriction(String restriction) {
        var getAllNutritionPlanByRestrictionQuery = new GetAllNutritionPlanByRestrictionQuery(restriction);
        var nutritionPlan = nutritionPlanQueryService.handle(getAllNutritionPlanByRestrictionQuery);
        return buildResponse(nutritionPlan);
    }
    /**
     * Get all nutrition plans by calories
     * @param calories - The calories of the nutrition plan
     * @return a response entity with the nutrition plans
     */
    private ResponseEntity<List<NutritionPlanResource>> getAllNutritionPlanByCalories(String calories) {
        var getAllNutritionPlanByCaloriesQuery = new GetAllNutritionPlanByCaloriesQuery(calories);
        var nutritionPlan = nutritionPlanQueryService.handle(getAllNutritionPlanByCaloriesQuery);
        return buildResponse(nutritionPlan);
    }
    /**
     * Get all nutrition plans by ingredients
     * @param ingredients - The ingredients of the nutrition plan
     * @return a response entity with the nutrition plans
     */
    private ResponseEntity<List<NutritionPlanResource>> getAllNutritionPlanByIngredients(String ingredients) {
        var getAllNutritionPlanByIngredientsQuery = new GetAllNutritionPlanByIngredientsQuery(ingredients);
        var nutritionPlan = nutritionPlanQueryService.handle(getAllNutritionPlanByIngredientsQuery);
        return buildResponse(nutritionPlan);
    }
    /**
     * Get all nutrition plans by description
     * @param description - The description of the nutrition plan
     * @return a response entity with the nutrition plans
     */
    private ResponseEntity<List<NutritionPlanResource>> getAllNutritionPlanByDescription(String description) {
        var getAllNutritionPlanByDescriptionQuery = new GetAllNutritionPlanByDescriptionQuery(description);
        var nutritionPlan = nutritionPlanQueryService.handle(getAllNutritionPlanByDescriptionQuery);
        return buildResponse(nutritionPlan);
    }

    private ResponseEntity<NutritionPlanResource> getNutritionPlanByTitleAndGoalHealth(String title, String goaltHealth) {
        var getNutritionPlanByTitleAndGoalHealthQuery = new GetNutritionPlanByTitleAndGoalHealthQuery(title, goaltHealth);
        var nutritionPlan = nutritionPlanQueryService.handle(getNutritionPlanByTitleAndGoalHealthQuery);
        if (nutritionPlan.isEmpty()) return ResponseEntity.notFound().build();
        return nutritionPlan.map(source -> ResponseEntity.ok(NutritionPlanResourceFromEntityAssembler.toResourceFromEntity(source))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Get nutrition plans with parameters
     * @param parameters - The parameters to get nutrition plans
     * @return a response entity with the nutrition plans
     */
    @GetMapping
    public ResponseEntity<?> getNutritionPlansWithParameters(@RequestParam Map<String, String> parameters) {
        if (parameters.containsKey("title") && parameters.containsKey("goalHealth")) {
            return getNutritionPlanByTitleAndGoalHealth(parameters.get("title"), parameters.get("goalHealth"));
        } else if (parameters.containsKey("title")) {
            return getAllNutritionPlanByTitle(parameters.get("title"));
        } else if (parameters.containsKey("goalHealth")) {
            return getAllNutritionPlanByGoalHealth(parameters.get("goalHealth"));
        } else if (parameters.containsKey("restriction")) {
            return getAllNutritionPlanByRestriction(parameters.get("restriction"));
        } else if (parameters.containsKey("calories")) {
            return getAllNutritionPlanByCalories(parameters.get("calories"));
        } else if (parameters.containsKey("ingredients")) {
            return getAllNutritionPlanByIngredients(parameters.get("ingredients"));
        } else if (parameters.containsKey("description")) {
            return getAllNutritionPlanByDescription(parameters.get("description"));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }



}
