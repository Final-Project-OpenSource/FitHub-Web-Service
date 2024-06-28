package com.acme.backend.fithubpro.rutines.interfaces.rest.transform;

import com.acme.backend.fithubpro.rutines.domain.model.aggregate.Rutines;
import com.acme.backend.fithubpro.rutines.interfaces.rest.resources.RutinesResource;

public class RutinesResourceFromEntityAssembler {
    public static RutinesResource toResourceFromEntity(Rutines entity) {
        return new RutinesResource(
                entity.getId(),
                entity.getName(),
                entity.getExercise(),
                entity.getRepetition(),
                entity.getPhoto(),
                entity.getInstruction(),
                entity.getCoachId(),
                entity.getMemberId()
        );
    }
}
