package com.acme.backend.fithubpro.subscription.domain.model.queries;

public record GetAllMembershipByTypeAndBenefitsQuery(String type, String benefits) {
    public GetAllMembershipByTypeAndBenefitsQuery {
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("type cannot be null or empty");
        }
        if (benefits == null || benefits.isBlank()) {
            throw new IllegalArgumentException("benefits cannot be null or empty");
        }
    }
}
