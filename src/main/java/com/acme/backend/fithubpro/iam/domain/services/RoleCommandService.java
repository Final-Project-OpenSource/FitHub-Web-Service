package com.acme.backend.fithubpro.iam.domain.services;

import com.acme.backend.fithubpro.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
