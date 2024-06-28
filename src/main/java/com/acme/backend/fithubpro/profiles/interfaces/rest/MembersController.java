package com.acme.backend.fithubpro.profiles.interfaces.rest;

import com.acme.backend.fithubpro.profiles.application.internal.commandservices.MemberCommandServiceImpl;
import com.acme.backend.fithubpro.profiles.application.internal.queryservices.MemberQueryServiceImpl;
import com.acme.backend.fithubpro.profiles.domain.model.aggregates.Member;
import com.acme.backend.fithubpro.profiles.interfaces.rest.resources.CreateMemberResource;
import com.acme.backend.fithubpro.profiles.interfaces.rest.resources.UpdateMemberResource;
import com.acme.backend.fithubpro.profiles.interfaces.rest.resources.MemberResource;
import com.acme.backend.fithubpro.profiles.interfaces.rest.transform.CreateMemberCommandFromResourceAssembler;
import com.acme.backend.fithubpro.profiles.interfaces.rest.transform.UpdateMemberCommandFromResourceAssembler;
import com.acme.backend.fithubpro.profiles.interfaces.rest.transform.MemberResourceFromEntityAssembler;
import com.acme.backend.fithubpro.profiles.domain.model.queries.GetAllMembersQuery;
import com.acme.backend.fithubpro.profiles.domain.model.queries.GetMemberByIdQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/members")
public class MembersController {

    private final MemberCommandServiceImpl memberCommandService;
    private final MemberQueryServiceImpl memberQueryService;

    public MembersController(MemberCommandServiceImpl memberCommandService, MemberQueryServiceImpl memberQueryService) {
        this.memberCommandService = memberCommandService;
        this.memberQueryService = memberQueryService;
    }

    @PostMapping
    public ResponseEntity<MemberResource> createMember(@RequestBody CreateMemberResource resource) {
        var command = CreateMemberCommandFromResourceAssembler.toCommandFromResource(resource);
        var member = memberCommandService.handle(command);
        return member.map(value -> ResponseEntity.ok(MemberResourceFromEntityAssembler.toResourceFromEntity(value)))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberResource> updateMember(@RequestBody UpdateMemberResource resource) {
        var command = UpdateMemberCommandFromResourceAssembler.toCommandFromResource(resource);
        var member = memberCommandService.handle(command);
        return member.map(value -> ResponseEntity.ok(MemberResourceFromEntityAssembler.toResourceFromEntity(value)))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberResource> getMemberById(@PathVariable Long id) {
        var query = new GetMemberByIdQuery(id);
        var member = memberQueryService.handle(query);
        return member.map(value -> ResponseEntity.ok(MemberResourceFromEntityAssembler.toResourceFromEntity(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<MemberResource> getAllMembers() {
        var query = new GetAllMembersQuery();
        var members = memberQueryService.handle(query);
        return members.stream()
                .map(MemberResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
    }
}