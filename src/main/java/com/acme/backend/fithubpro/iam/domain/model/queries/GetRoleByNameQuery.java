package com.acme.backend.fithubpro.iam.domain.model.queries;

import com.acme.backend.fithubpro.iam.domain.model.valueobjects.Roles;

public record GetRoleByNameQuery(Roles name) {
}
