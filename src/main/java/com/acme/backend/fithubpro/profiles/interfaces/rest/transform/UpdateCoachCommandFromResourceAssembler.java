package com.acme.backend.fithubpro.profiles.interfaces.rest.transform;

import com.acme.backend.fithubpro.profiles.domain.model.commands.UpdateCoachCommand;
import com.acme.backend.fithubpro.profiles.interfaces.rest.resources.UpdateCoachResource;

public class UpdateCoachCommandFromResourceAssembler {
    public static UpdateCoachCommand toCommandFromResource(UpdateCoachResource resource) {
        return new UpdateCoachCommand(resource.coachId(), resource.profileId(), resource.specialty(), resource.certification(), resource.yearsOfExperience());
    }
}