package com.acme.backend.fithubpro.iam.interfaces.rest.transform;

import com.acme.backend.fithubpro.iam.domain.model.entities.Role;
import com.acme.backend.fithubpro.iam.interfaces.rest.resources.RoleResource;

public class RoleResourceFromEntityAssembler {
    public static RoleResource toResourceFromEntity(Role role) {
        return new RoleResource(role.getId(), role.getStringName());
    }
}
