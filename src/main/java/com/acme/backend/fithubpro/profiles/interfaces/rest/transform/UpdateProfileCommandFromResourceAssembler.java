package com.acme.backend.fithubpro.profiles.interfaces.rest.transform;

import com.acme.backend.fithubpro.profiles.domain.model.commands.UpdateProfileCommand;
import com.acme.backend.fithubpro.profiles.interfaces.rest.resources.UpdateProfileResource;

public class UpdateProfileCommandFromResourceAssembler {

        public static UpdateProfileCommand fromResource(UpdateProfileResource resource) {
            return new UpdateProfileCommand(resource.firstName(), resource.lastName(), resource.email(), resource.street(), resource.number(), resource.city(), resource.postalCode(), resource.country(), resource.profileImageUrl());
        }

}
