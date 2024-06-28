package com.acme.backend.fithubpro.profiles.interfaces.rest.transform;

import com.acme.backend.fithubpro.profiles.domain.model.commands.UpdateMemberCommand;
import com.acme.backend.fithubpro.profiles.interfaces.rest.resources.UpdateMemberResource;

public class UpdateMemberCommandFromResourceAssembler {
    public static UpdateMemberCommand toCommandFromResource(UpdateMemberResource resource) {
        return new UpdateMemberCommand(resource.memberId(), resource.profileId(), resource.healthGoal());
    }
}
