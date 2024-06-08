package com.acme.backend.fithubpro.subscription.interfaces.rest.transform;

import com.acme.backend.fithubpro.subscription.domain.model.commands.CreateMembershipCommand;
import com.acme.backend.fithubpro.subscription.interfaces.rest.resources.CreateMembershipResource;

public class CreateMembershipCommandFromResourceAssembler {
    public static CreateMembershipCommand toCommandFromResource(CreateMembershipResource resource){
        return new CreateMembershipCommand(resource.benefits(), resource.price(), resource.type());
    }
}
