package com.acme.backend.fithubpro.progress.interfaces.rest.transform;

import com.acme.backend.fithubpro.progress.domain.model.commands.CreateProgressCommand;
import com.acme.backend.fithubpro.progress.interfaces.rest.resources.CreateProgressResource;

public final class CreateProgressCommandFromResourceAssembler {

    private CreateProgressCommandFromResourceAssembler() {}

    public static CreateProgressCommand toCommandFromResource(CreateProgressResource resource) {
        return new CreateProgressCommand(resource.content(), resource.date(), resource.clientId(), resource.coachId());
    }
}
