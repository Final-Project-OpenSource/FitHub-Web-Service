package com.acme.backend.fithubpro.subscription.interfaces.rest.controller;


import com.acme.backend.fithubpro.subscription.domain.model.aggregates.Membership;
import com.acme.backend.fithubpro.subscription.domain.model.queries.GetAllMembershipByBenefitsQuery;
import com.acme.backend.fithubpro.subscription.domain.model.queries.GetAllMembershipByPriceQuery;
import com.acme.backend.fithubpro.subscription.domain.model.queries.GetAllMembershipByTypeAndBenefitsQuery;
import com.acme.backend.fithubpro.subscription.domain.model.queries.GetAllMembershipByTypeQuery;
import com.acme.backend.fithubpro.subscription.domain.services.MembershipCommandService;
import com.acme.backend.fithubpro.subscription.domain.services.MembershipQueryService;
import com.acme.backend.fithubpro.subscription.interfaces.rest.resources.CreateMembershipResource;
import com.acme.backend.fithubpro.subscription.interfaces.rest.resources.MembershipResource;
import com.acme.backend.fithubpro.subscription.interfaces.rest.transform.CreateMembershipCommandFromResourceAssembler;
import com.acme.backend.fithubpro.subscription.interfaces.rest.transform.MembershipResourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("api/v1/membership")
public class MembershipController {

    private final MembershipCommandService membershipCommandService;
    private final MembershipQueryService membershipQueryService;

    public MembershipController(MembershipCommandService membershipCommandService, MembershipQueryService membershipQueryService) {
        this.membershipCommandService = membershipCommandService;
        this.membershipQueryService = membershipQueryService;
    }

    @PostMapping
    public ResponseEntity<MembershipResource> CreateMembership(@RequestBody CreateMembershipResource resource) {
        Optional<Membership> membership = membershipCommandService.handle(CreateMembershipCommandFromResourceAssembler.toCommandFromResource(resource));
        return membership.map(source -> new ResponseEntity<>(MembershipResourceFromEntityAssembler.toResourceFromEntity(source), CREATED)).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    /**
     * Build a response entity with the provided memberships
     * @param memberships - The list of memberships
     * @return a response entity with the memberships
     */
    private ResponseEntity<List<MembershipResource>> buildResponse(List<Membership> memberships) {
        if (memberships.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var membershipResources = memberships.stream()
                .map(MembershipResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(membershipResources);
    }

    /**
     * Get all memberships by benefits
     * @param benefits - The benefits of the membership
     * @return a response entity with the memberships
     */
    private ResponseEntity<List<MembershipResource>> getAllMembershipByBenefits(String benefits) {
        var getAllMembershipByBenefitsQuery = new GetAllMembershipByBenefitsQuery(benefits);
        var memberships = membershipQueryService.handle(getAllMembershipByBenefitsQuery);
        return buildResponse(memberships);
    }

    /**
     * Get all memberships by type
     * @param type - The type of the membership
     * @return a response entity with the memberships
     */
    private ResponseEntity<List<MembershipResource>> getAllMembershipByType(String type) {
        var getAllMembershipByTypeQuery = new GetAllMembershipByTypeQuery(type);
        var memberships = membershipQueryService.handle(getAllMembershipByTypeQuery);
        return buildResponse(memberships);
    }

    /**
     * Get all memberships by price
     * @param price - The price of the membership
     * @return a response entity with the memberships
     */
    private ResponseEntity<List<MembershipResource>> getAllMembershipByPrice(double price) {
        var getAllMembershipByPriceQuery = new GetAllMembershipByPriceQuery(price);
        var memberships = membershipQueryService.handle(getAllMembershipByPriceQuery);
        return buildResponse(memberships);
    }

    /**
     * Get a membership by type and benefits
     * @param type - The type of membership plan
     * @param benefits - The benefits of the membership
     * @return a response entity with the membership
     */
    private ResponseEntity<MembershipResource> getAllMembershipPlanByTypeAndBenefits(String type, String benefits) {
        var getAllMembershipByTypeAndBenefitsQuery = new GetAllMembershipByTypeAndBenefitsQuery(type, benefits);
        var membership = membershipQueryService.handle(getAllMembershipByTypeAndBenefitsQuery);
        if (membership.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return membership.map(source -> ResponseEntity.ok(MembershipResourceFromEntityAssembler.toResourceFromEntity(source))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Get membership with parameters
     * @param parameters - The parameters to get membership
     * @return a response entity with the membership
     */
    @GetMapping
    public ResponseEntity<?> getMembershipWithParameters(@RequestParam Map<String, String> parameters) {
        if (parameters.containsKey("benefits") && parameters.containsKey("type")) {
            return getAllMembershipPlanByTypeAndBenefits(parameters.get("type"), parameters.get("benefits"));
        } else if (parameters.containsKey("benefits")) {
            return getAllMembershipByBenefits(parameters.get("benefits"));
        } else if (parameters.containsKey("type")) {
            return getAllMembershipByType(parameters.get("type"));
        } else if (parameters.containsKey("price")) {
            return getAllMembershipByPrice(Double.parseDouble(parameters.get("price")));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }



}
