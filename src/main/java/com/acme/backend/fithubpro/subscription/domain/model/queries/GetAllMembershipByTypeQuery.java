package com.acme.backend.fithubpro.subscription.domain.model.queries;

public record GetAllMembershipByTypeQuery(String type) {
    public GetAllMembershipByTypeQuery {
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("type cannot be null or empty");
        }
    }
}
