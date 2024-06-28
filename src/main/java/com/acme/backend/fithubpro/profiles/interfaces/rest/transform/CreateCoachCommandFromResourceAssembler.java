package com.acme.backend.fithubpro.profiles.interfaces.rest.transform;

import com.acme.backend.fithubpro.profiles.domain.model.commands.CreateCoachCommand;
import com.acme.backend.fithubpro.profiles.interfaces.rest.resources.CreateCoachResource;

public class CreateCoachCommandFromResourceAssembler {
    public static CreateCoachCommand toCommandFromResource(CreateCoachResource resource) {
        return new CreateCoachCommand(resource.profileId(), resource.specialty(), resource.certification(), resource.yearsOfExperience());
    }
}