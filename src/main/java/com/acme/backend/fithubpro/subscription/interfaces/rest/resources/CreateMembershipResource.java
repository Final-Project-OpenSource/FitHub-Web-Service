package com.acme.backend.fithubpro.subscription.interfaces.rest.resources;

public record CreateMembershipResource(String benefits, Double price, String type) {
    public CreateMembershipResource{
        if (price == null || price <= 0) {
            throw new IllegalArgumentException("price cannot be null or less or equal than 0");
        }
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("type cannot be null or empty");
        }
        if (benefits == null || benefits.isBlank()) {
            throw new IllegalArgumentException("type cannot be null or empty");
        }
    }
}
