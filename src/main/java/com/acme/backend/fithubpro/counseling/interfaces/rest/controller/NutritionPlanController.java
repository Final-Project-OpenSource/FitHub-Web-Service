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
    public ResponseEntity<List<NutritionPlanResource>> getAllNutritionPlans() {
        List<NutritionPlan> nutritionPlans = nutritionPlanQueryService.getAllNutritionPlans();
        return buildResponse(nutritionPlans);
    }

    @GetMapping("/coach/{coachId}")
    public ResponseEntity<List<NutritionPlanResource>> getNutritionPlansByCoachId(@PathVariable Long coachId) {
        List<NutritionPlan> nutritionPlans = nutritionPlanQueryService.getNutritionPlansByCoachId(coachId);
        return buildResponse(nutritionPlans);
    }

    @PutMapping("{id}")
    public ResponseEntity<NutritionPlanResource> updateNutritionPlan(@PathVariable Long id, @RequestBody CreateNutritionPlanResource resource) {
        Optional<NutritionPlan> nutritionPlan = nutritionPlanCommandService.update(id, CreateNutritionPlanCommandFromResourceAssembler.toCommandFromResource(resource));
        return nutritionPlan.map(plan -> ResponseEntity.ok(NutritionPlanResourceFromEntityAssembler.toResourceFromEntity(plan))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteNutritionPlan(@PathVariable Long id) {
        nutritionPlanCommandService.delete(id);
        return ResponseEntity.noContent().build();
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
