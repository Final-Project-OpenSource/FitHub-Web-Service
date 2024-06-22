package com.acme.backend.fithubpro.subscription.domain.model.queries;

public record GetAllMembershipByBenefitsQuery(String benefits) {
    public GetAllMembershipByBenefitsQuery {
        if (benefits == null || benefits.isBlank()) {
            throw new IllegalArgumentException("benefits cannot be null or empty");
        }
    }
}
