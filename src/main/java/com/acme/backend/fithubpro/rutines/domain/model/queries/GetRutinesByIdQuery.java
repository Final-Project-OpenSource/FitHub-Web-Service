package com.acme.backend.fithubpro.rutines.domain.model.queries;

public record GetRutinesByIdQuery(Long id) {
    public GetRutinesByIdQuery {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
    }
}
