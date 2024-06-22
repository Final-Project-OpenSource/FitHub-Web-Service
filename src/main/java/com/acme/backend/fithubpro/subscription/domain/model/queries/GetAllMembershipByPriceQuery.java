package com.acme.backend.fithubpro.subscription.domain.model.queries;

public record GetAllMembershipByPriceQuery(Double price) {
    public GetAllMembershipByPriceQuery {
        if (price == null || price<=0) {
            throw new IllegalArgumentException("price cannot be null or less or equal to 0");
        }
    }
}
