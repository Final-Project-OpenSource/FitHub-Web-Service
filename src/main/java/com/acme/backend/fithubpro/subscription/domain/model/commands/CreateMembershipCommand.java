package com.acme.backend.fithubpro.subscription.domain.model.commands;

public record CreateMembershipCommand(String benefits, Double price, String type ) {
    public CreateMembershipCommand {
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
