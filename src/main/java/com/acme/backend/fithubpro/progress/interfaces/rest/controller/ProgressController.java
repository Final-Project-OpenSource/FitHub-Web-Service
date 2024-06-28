package com.acme.backend.fithubpro.progress.interfaces.rest.controller;

import com.acme.backend.fithubpro.progress.domain.model.aggregate.Progress;
import com.acme.backend.fithubpro.progress.domain.services.ProgressCommandService;
import com.acme.backend.fithubpro.progress.domain.services.ProgressQueryService;
import com.acme.backend.fithubpro.progress.domain.model.queries.GetAllProgressByClientIdQuery;
import com.acme.backend.fithubpro.progress.domain.model.queries.GetProgressByIdAndClientIdQuery;
import com.acme.backend.fithubpro.progress.interfaces.rest.resources.CreateProgressResource;
import com.acme.backend.fithubpro.progress.interfaces.rest.resources.ProgressResource;
import com.acme.backend.fithubpro.progress.interfaces.rest.transform.CreateProgressCommandFromResourceAssembler;
import com.acme.backend.fithubpro.progress.interfaces.rest.transform.ProgressResourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("api/v1/progress")
public class ProgressController {

    private final ProgressCommandService progressCommandService;
    private final ProgressQueryService progressQueryService;

    public ProgressController(ProgressQueryService progressQueryService, ProgressCommandService progressCommandService) {
        this.progressCommandService = progressCommandService;
        this.progressQueryService = progressQueryService;
    }

    @PostMapping
    public ResponseEntity<ProgressResource> createProgress(@RequestBody CreateProgressResource resource) {
        Optional<Progress> progress = progressCommandService.handle(CreateProgressCommandFromResourceAssembler.toCommandFromResource(resource));
        return progress.map(source ->
                new ResponseEntity<>(ProgressResourceFromEntityAssembler.toResourceFromEntity(source), CREATED)).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("{id}")
    public ResponseEntity<ProgressResource> getProgressByIdAndClientId(@PathVariable Long id, @RequestParam Integer clientId) {
        Optional<Progress> progress = progressQueryService.handle(new GetProgressByIdAndClientIdQuery(id, clientId));
        return progress.map(source -> ResponseEntity.ok(ProgressResourceFromEntityAssembler.toResourceFromEntity(source))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ProgressResource>> getProgressByClientId(@RequestParam Integer clientId) {
        List<Progress> progressList = progressQueryService.handle(new GetAllProgressByClientIdQuery(clientId));
        if (progressList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var progressResources = progressList.stream()
                .map(ProgressResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(progressResources);
    }

    @GetMapping("/client/{clientId}/coach/{coachId}")
    public ResponseEntity<List<ProgressResource>> getProgressByClientIdAndCoachId(@PathVariable Integer clientId, @PathVariable Integer coachId) {
        List<Progress> progressList = progressQueryService.getProgressByClientIdAndCoachId(clientId, coachId);
        if (progressList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var progressResources = progressList.stream()
                .map(ProgressResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(progressResources);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProgressResource> updateProgress(@PathVariable Long id, @RequestBody CreateProgressResource resource) {
        Optional<Progress> progress = progressCommandService.update(id, CreateProgressCommandFromResourceAssembler.toCommandFromResource(resource));
        return progress.map(source -> ResponseEntity.ok(ProgressResourceFromEntityAssembler.toResourceFromEntity(source))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProgress(@PathVariable Long id) {
        progressCommandService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
