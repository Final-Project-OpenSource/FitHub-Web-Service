package com.acme.backend.fithubpro.rutines.domain.model.queries;

public record GetAllRutinesByInstructionQuery(String instruction) {
    public GetAllRutinesByInstructionQuery {
        if (instruction == null || instruction.isBlank()) {
            throw new IllegalArgumentException("Instruction cannot be null or empty");
        }
    }
}
