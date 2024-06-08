package com.acme.backend.fithubpro.progress.domain.model.queries;

public record GetProgressByIdAndClientIdQuery(Long id, Integer clientId) {
            public GetProgressByIdAndClientIdQuery {
                if (id == null) {
                    throw new IllegalArgumentException("id cannot be null");
                }
                if (clientId == null) {
                    throw new IllegalArgumentException("clientId cannot be null");
                }
            }
}
