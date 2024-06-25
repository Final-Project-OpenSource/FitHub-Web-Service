// NutritionPlanController.java
package com.acme.backend.fithubpro.counseling.interfaces.rest.controller;

import com.acme.backend.fithubpro.counseling.domain.model.aggregate.NutritionPlan;
import com.acme.backend.fithubpro.counseling.domain.model.commands.CreateNutritionPlanCommand;
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

    public NutritionPlanController(NutritionPlanCommandService nutritionPlanCommandService, NutritionPlanQueryService nutritionPlanQueryService) {
        this.nutritionPlanCommandService = nutritionPlanCommandService;
        this.nutritionPlanQueryService = nutritionPlanQueryService;
    }

    @PostMapping
    public ResponseEntity<NutritionPlanResource> createNutritionPlan(@RequestBody CreateNutritionPlanResource resource) {
        Optional<NutritionPlan> nutritionPlan = nutritionPlanCommandService.handle(CreateNutritionPlanCommandFromResourceAssembler.toCommandFromResource(resource));
        return nutritionPlan.map(plan ->
                new ResponseEntity<>(NutritionPlanResourceFromEntityAssembler.toResourceFromEntity(plan), CREATED)).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("{id}")
    public ResponseEntity<NutritionPlanResource> getNutritionPlanById(@PathVariable Long id) {
        Optional<NutritionPlan> nutritionPlan = nutritionPlanQueryService.handle(new GetNutritionPlanByIdQuery(id));
        return nutritionPlan.map(plan -> ResponseEntity.ok(NutritionPlanResourceFromEntityAssembler.toResourceFromEntity(plan))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<NutritionPlanResource>> getNutritionPlansWithParameters(@RequestParam Map<String, String> parameters) {
        if (parameters.containsKey("title") && parameters.containsKey("goalHealth")) {
            var query = new GetNutritionPlanByTitleAndGoalHealthQuery(parameters.get("title"), parameters.get("goalHealth"));
            Optional<NutritionPlan> nutritionPlan = nutritionPlanQueryService.handle(query);
            return nutritionPlan.map(plan -> ResponseEntity.ok(List.of(NutritionPlanResourceFromEntityAssembler.toResourceFromEntity(plan)))).orElseGet(() -> ResponseEntity.notFound().build());
        } else if (parameters.containsKey("title")) {
            var query = new GetAllNutritionPlanByTitleQuery(parameters.get("title"));
            return buildResponse(nutritionPlanQueryService.handle(query));
        } else if (parameters.containsKey("goalHealth")) {
            var query = new GetAllNutritionPlanByGoalHealthQuery(parameters.get("goalHealth"));
            return buildResponse(nutritionPlanQueryService.handle(query));
        } else if (parameters.containsKey("restriction")) {
            var query = new GetAllNutritionPlanByRestrictionQuery(parameters.get("restriction"));
            return buildResponse(nutritionPlanQueryService.handle(query));
        } else if (parameters.containsKey("calories")) {
            var query = new GetAllNutritionPlanByCaloriesQuery(parameters.get("calories"));
            return buildResponse(nutritionPlanQueryService.handle(query));
        } else if (parameters.containsKey("ingredients")) {
            var query = new GetAllNutritionPlanByIngredientsQuery(parameters.get("ingredients"));
            return buildResponse(nutritionPlanQueryService.handle(query));
        } else if (parameters.containsKey("description")) {
            var query = new GetAllNutritionPlanByDescriptionQuery(parameters.get("description"));
            return buildResponse(nutritionPlanQueryService.handle(query));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    private ResponseEntity<List<NutritionPlanResource>> buildResponse(List<NutritionPlan> nutritionPlans) {
        if (nutritionPlans.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var nutritionPlanResources = nutritionPlans.stream()
                .map(NutritionPlanResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(nutritionPlanResources);
    }
}
