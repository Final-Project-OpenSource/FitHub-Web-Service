package com.acme.backend.fithubpro.profiles.interfaces.rest;


import com.acme.backend.fithubpro.profiles.application.internal.commandservices.CoachCommandServiceImpl;
import com.acme.backend.fithubpro.profiles.application.internal.queryservices.CoachQueryServiceImpl;
import com.acme.backend.fithubpro.profiles.domain.model.aggregates.Coach;
import com.acme.backend.fithubpro.profiles.interfaces.rest.resources.CreateCoachResource;
import com.acme.backend.fithubpro.profiles.interfaces.rest.resources.UpdateCoachResource;
import com.acme.backend.fithubpro.profiles.interfaces.rest.resources.CoachResource;
import com.acme.backend.fithubpro.profiles.interfaces.rest.transform.CreateCoachCommandFromResourceAssembler;
import com.acme.backend.fithubpro.profiles.interfaces.rest.transform.UpdateCoachCommandFromResourceAssembler;
import com.acme.backend.fithubpro.profiles.interfaces.rest.transform.CoachResourceFromEntityAssembler;
import com.acme.backend.fithubpro.profiles.domain.model.queries.GetAllCoachesQuery;
import com.acme.backend.fithubpro.profiles.domain.model.queries.GetCoachByIdQuery;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/coaches", produces = MediaType.APPLICATION_JSON_VALUE)
public class CoachesController {

    private final CoachCommandServiceImpl coachCommandService;
    private final CoachQueryServiceImpl coachQueryService;

    public CoachesController(CoachCommandServiceImpl coachCommandService, CoachQueryServiceImpl coachQueryService) {
        this.coachCommandService = coachCommandService;
        this.coachQueryService = coachQueryService;
    }

    @PostMapping
    public ResponseEntity<CoachResource> createCoach(@RequestBody CreateCoachResource resource) {
        var command = CreateCoachCommandFromResourceAssembler.toCommandFromResource(resource);
        var coach = coachCommandService.handle(command);
        return coach.map(value -> ResponseEntity.ok(CoachResourceFromEntityAssembler.toResourceFromEntity(value)))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CoachResource> updateCoach(@RequestBody UpdateCoachResource resource) {
        var command = UpdateCoachCommandFromResourceAssembler.toCommandFromResource(resource);
        var coach = coachCommandService.handle(command);
        return coach.map(value -> ResponseEntity.ok(CoachResourceFromEntityAssembler.toResourceFromEntity(value)))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoachResource> getCoachById(@PathVariable Long id) {
        var query = new GetCoachByIdQuery(id);
        var coach = coachQueryService.handle(query);
        return coach.map(value -> ResponseEntity.ok(CoachResourceFromEntityAssembler.toResourceFromEntity(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<CoachResource> getAllCoaches() {
        var query = new GetAllCoachesQuery();
        var coaches = coachQueryService.handle(query);
        return coaches.stream()
                .map(CoachResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
    }
}
