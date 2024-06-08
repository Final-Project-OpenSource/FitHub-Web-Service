package com.acme.backend.fithubpro.rutines.domain.model.queries;

public record GetAllRutinesByIntructionQuery(String instruction) {
    public GetAllRutinesByIntructionQuery{
        if (instruction == null || instruction.isBlank()) {
            throw new IllegalArgumentException("instruction cannot be null");
        }
    }
}
