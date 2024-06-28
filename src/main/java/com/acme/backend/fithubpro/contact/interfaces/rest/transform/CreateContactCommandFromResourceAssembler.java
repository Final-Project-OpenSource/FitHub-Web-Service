package com.acme.backend.fithubpro.contact.interfaces.rest.transform;

import com.acme.backend.fithubpro.contact.domain.model.commands.CreateContactCommand;
import com.acme.backend.fithubpro.contact.interfaces.rest.resources.CreateContactResource;

public final class CreateContactCommandFromResourceAssembler {

    private CreateContactCommandFromResourceAssembler() {}

    public static CreateContactCommand toCommandFromResource(CreateContactResource resource) {
        return new CreateContactCommand(resource.message(), resource.memberId(), resource.coachId());
    }
}
