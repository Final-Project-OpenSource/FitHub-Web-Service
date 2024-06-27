package com.acme.backend.fithubpro.rutines.domain.model.queries;

public record GetAllRutinesBynameQuery(String name) {
    public GetAllRutinesBynameQuery{
        if (name == null){
            throw new IllegalArgumentException("name cannot be null");
        }
    }
}
