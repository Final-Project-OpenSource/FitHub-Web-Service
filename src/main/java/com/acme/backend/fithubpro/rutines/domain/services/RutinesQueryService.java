package com.acme.backend.fithubpro.rutines.domain.services;

import com.acme.backend.fithubpro.rutines.domain.model.aggregate.Rutines;
import com.acme.backend.fithubpro.rutines.domain.model.queries.*;
import java.util.List;
import java.util.Optional;

public interface RutinesQueryService {
    List<Rutines> handle(GetAllRutinesByExerciseQuery query);
    List<Rutines> handle(GetAllRutinesByInstructionQuery query);
    Optional<Rutines> handle(GetRutinesByIdQuery query);
    List<Rutines> getAllRutines();
    List<Rutines> getRutinesByCoachId(Long coachId);
}
