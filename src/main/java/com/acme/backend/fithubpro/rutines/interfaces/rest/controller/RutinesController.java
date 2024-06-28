package com.acme.backend.fithubpro.rutines.interfaces.rest.controller;

import com.acme.backend.fithubpro.rutines.domain.model.aggregate.Rutines;
import com.acme.backend.fithubpro.rutines.domain.model.queries.GetAllRutinesByIntructionQuery;
import com.acme.backend.fithubpro.rutines.domain.model.queries.GetAllRutinesByExerciseQuery;
import com.acme.backend.fithubpro.rutines.domain.model.queries.GetRutinesByIdQuery;
import com.acme.backend.fithubpro.rutines.domain.services.RutinesCommandService;
import com.acme.backend.fithubpro.rutines.domain.services.RutinesQueryService;
import com.acme.backend.fithubpro.rutines.interfaces.rest.resources.CreateRutinesResource;
import com.acme.backend.fithubpro.rutines.interfaces.rest.resources.RutinesResource;
import com.acme.backend.fithubpro.rutines.interfaces.rest.transform.CreateRutinesCommandFromResourceAssembler;
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
    public ResponseEntity<RutinesResource> createRutines(@RequestBody CreateRutinesResource resource){
        Optional<Rutines> rutines = rutinesCommandService.handle(CreateRutinesCommandFromResourceAssembler.toCommandFromResource(resource));
        return rutines.map(source ->
                new ResponseEntity<>(RutinesResourceFromEntityAssembler.toResourceFromEntity(source), CREATED)).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("{id}")
    public ResponseEntity<RutinesResource> getRutinesById(@PathVariable Long id){
        Optional<Rutines> rutines = rutinesQueryService.handle(new GetRutinesByIdQuery(id));
        return rutines.map(source -> ResponseEntity.ok(RutinesResourceFromEntityAssembler.toResourceFromEntity(source))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<RutinesResource>> getAllRutines(){
        List<Rutines> rutines = rutinesQueryService.getAllRutines();
        return buildResponse(rutines);
    }

    @GetMapping("/coach/{coachId}")
    public ResponseEntity<List<RutinesResource>> getRutinesByCoachId(@PathVariable Long coachId){
        List<Rutines> rutines = rutinesQueryService.getRutinesByCoachId(coachId);
        return buildResponse(rutines);
    }

    @PutMapping("{id}")
    public ResponseEntity<RutinesResource> updateRutines(@PathVariable Long id, @RequestBody CreateRutinesResource resource){
        Optional<Rutines> rutines = rutinesCommandService.update(id, CreateRutinesCommandFromResourceAssembler.toCommandFromResource(resource));
        return rutines.map(source -> ResponseEntity.ok(RutinesResourceFromEntityAssembler.toResourceFromEntity(source))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteRutines(@PathVariable Long id){
        rutinesCommandService.delete(id);
        return ResponseEntity.noContent().build();
    }

    private ResponseEntity<List<RutinesResource>> buildResponse(List<Rutines> rutines){
        if(rutines.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var rutinesResources = rutines.stream()
                .map(RutinesResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(rutinesResources);
    }

    private ResponseEntity<List<RutinesResource>> getAllRutinesByExercise(String exercise){
        var getAllRutinesByExercise = new GetAllRutinesByExerciseQuery(exercise);
        var rutines = rutinesQueryService.handle(getAllRutinesByExercise);
        return buildResponse(rutines);
    }

    private ResponseEntity<List<RutinesResource>> getAllRutinesByInstruction(String instruction){
        var getAllRutinesByInstruction = new GetAllRutinesByIntructionQuery(instruction);
        var rutines = rutinesQueryService.handle(getAllRutinesByInstruction);
        return buildResponse(rutines);
    }
}
