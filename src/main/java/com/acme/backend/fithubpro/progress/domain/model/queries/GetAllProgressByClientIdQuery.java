package com.acme.backend.fithubpro.progress.domain.model.queries;

public record GetAllProgressByClientIdQuery(Integer clientId) {
    public GetAllProgressByClientIdQuery {
        if (clientId == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
    }
}
