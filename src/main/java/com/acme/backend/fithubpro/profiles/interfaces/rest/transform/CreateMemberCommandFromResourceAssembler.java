package com.acme.backend.fithubpro.profiles.interfaces.rest.transform;
import com.acme.backend.fithubpro.profiles.domain.model.commands.CreateMemberCommand;
import com.acme.backend.fithubpro.profiles.interfaces.rest.resources.CreateMemberResource;

public class CreateMemberCommandFromResourceAssembler {
    public static CreateMemberCommand toCommandFromResource(CreateMemberResource resource) {
        return new CreateMemberCommand(resource.profileId(), resource.healthGoal());
    }
}