package com.acme.backend.fithubpro.iam.interfaces.rest.transform;

import com.acme.backend.fithubpro.iam.domain.model.commands.SignInCommand;
import com.acme.backend.fithubpro.iam.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource signInResource) {
        return new SignInCommand(signInResource.username(), signInResource.password());
    }
}
