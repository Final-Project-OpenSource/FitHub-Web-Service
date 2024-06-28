package com.acme.backend.fithubpro.contact.interfaces.rest.controller;

import com.acme.backend.fithubpro.contact.domain.model.aggregate.Contact;
import com.acme.backend.fithubpro.contact.domain.services.ContactCommandService;
import com.acme.backend.fithubpro.contact.domain.services.ContactQueryService;
import com.acme.backend.fithubpro.contact.domain.model.queries.GetAllContactsQuery;
import com.acme.backend.fithubpro.contact.interfaces.rest.resources.CreateContactResource;
import com.acme.backend.fithubpro.contact.interfaces.rest.resources.ContactResource;
import com.acme.backend.fithubpro.contact.interfaces.rest.transform.CreateContactCommandFromResourceAssembler;
import com.acme.backend.fithubpro.contact.interfaces.rest.transform.ContactResourceFromEntityAssembler;
import com.acme.backend.fithubpro.rutines.domain.services.RutinesQueryService;
import com.acme.backend.fithubpro.counseling.domain.services.NutritionPlanQueryService;
import com.acme.backend.fithubpro.counseling.domain.model.queries.GetAllNutritionPlanByCoachIdQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("api/v1/contacts")
public class ContactController {

    private final ContactCommandService contactCommandService;
    private final ContactQueryService contactQueryService;
    private final RutinesQueryService rutinesQueryService;
    private final NutritionPlanQueryService nutritionPlanQueryService;

    public ContactController(ContactCommandService contactCommandService, ContactQueryService contactQueryService, RutinesQueryService rutinesQueryService, NutritionPlanQueryService nutritionPlanQueryService) {
        this.contactCommandService = contactCommandService;
        this.contactQueryService = contactQueryService;
        this.rutinesQueryService = rutinesQueryService;
        this.nutritionPlanQueryService = nutritionPlanQueryService;
    }

    @PostMapping
    public ResponseEntity<ContactResource> createContact(@RequestBody CreateContactResource resource) {
        Optional<Contact> contact = contactCommandService.handle(CreateContactCommandFromResourceAssembler.toCommandFromResource(resource));

        contact.ifPresent(c -> {
            // Lógica para obtener rutinas por CoachId
            var rutines = rutinesQueryService.getRutinesByCoachId(c.getCoachId().longValue());
            // Lógica para obtener planes nutricionales por CoachId
            var nutritionPlans = nutritionPlanQueryService.handle(new GetAllNutritionPlanByCoachIdQuery(c.getCoachId()));

            // Aquí se puede agregar cualquier lógica adicional que necesite realizarse después de obtener los datos
            // Por ejemplo, se podrían registrar logs, actualizar otros sistemas, etc.
        });

        return contact.map(source ->
                new ResponseEntity<>(ContactResourceFromEntityAssembler.toResourceFromEntity(source), CREATED)).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping
    public ResponseEntity<List<ContactResource>> getAllContacts() {
        List<Contact> contacts = contactQueryService.handle(new GetAllContactsQuery());
        if (contacts.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var contactResources = contacts.stream()
                .map(ContactResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(contactResources);
    }
}
