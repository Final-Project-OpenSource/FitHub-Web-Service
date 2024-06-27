package com.acme.backend.fithubpro.rutines.interfaces.rest.controller;

import com.acme.backend.fithubpro.rutines.domain.model.aggregate.Rutines;
import com.acme.backend.fithubpro.rutines.domain.model.queries.GetAllRutinesBynameQuery;
import com.acme.backend.fithubpro.rutines.domain.model.queries.GetRutinesByIdQuery;
import com.acme.backend.fithubpro.rutines.domain.services.RutinesCommandService;
import com.acme.backend.fithubpro.rutines.domain.services.RutinesQueryService;
import com.acme.backend.fithubpro.rutines.interfaces.rest.resources.CreateRutinesREsource;
import com.acme.backend.fithubpro.rutines.interfaces.rest.resources.RutinesResource;
import com.acme.backend.fithubpro.rutines.interfaces.rest.transform.CreateRutinescommandFromResourceAssembler;
import com.acme.backend.fithubpro.rutines.interfaces.rest.transform.RutinesResourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("api/v1/rutines")
public class RutinesController {
    private final RutinesCommandService rutinesCommandService;
    private final RutinesQueryService rutinesQueryService;

    public RutinesController(RutinesCommandService rutinesCommandService, RutinesQueryService rutinesQueryService) {
        this.rutinesCommandService = rutinesCommandService;
        this.rutinesQueryService = rutinesQueryService;
    }

    @PostMapping
    public ResponseEntity<RutinesResource> createRutines(@RequestBody CreateRutinesREsource resource) {
        Optional<Rutines> rutines = rutinesCommandService.handle(CreateRutinescommandFromResourceAssembler.toCommandFromResource(resource));
        return rutines.map(source ->
                new ResponseEntity<>(RutinesResourceFromEntityAssembler.toResourceFromEntity(source), CREATED)).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("{id}")
    public ResponseEntity<RutinesResource> getRutinesById(@PathVariable Long id) {
        Optional<Rutines> rutines = rutinesQueryService.handle(new GetRutinesByIdQuery(id));
        return rutines.map(source -> ResponseEntity.ok(RutinesResourceFromEntityAssembler.toResourceFromEntity(source))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<RutinesResource>> getRutinesByName(@RequestParam String name) {
        List<Rutines> rutines = rutinesQueryService.handle(new GetAllRutinesBynameQuery(name));
        if (rutines.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var rutinesResources = rutines.stream()
                .map(RutinesResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(rutinesResources);
    }

}
