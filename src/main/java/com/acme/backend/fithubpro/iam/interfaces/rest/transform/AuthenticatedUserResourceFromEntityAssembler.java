package com.acme.backend.fithubpro.iam.interfaces.rest.transform;

import com.acme.backend.fithubpro.iam.domain.model.aggregates.User;
import com.acme.backend.fithubpro.iam.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {
    public static AuthenticatedUserResource toResourceFromEntity(User user, String token) {
        return new AuthenticatedUserResource(user.getId(), user.getUsername(), token);
    }
}
