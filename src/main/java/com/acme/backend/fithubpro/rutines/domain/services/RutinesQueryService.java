package com.acme.backend.fithubpro.rutines.domain.services;

import com.acme.backend.fithubpro.rutines.domain.model.aggregate.Rutines;
import com.acme.backend.fithubpro.rutines.domain.model.queries.GetAllRutinesByIntructionQuery;
import com.acme.backend.fithubpro.rutines.domain.model.queries.GetAllRutinesByExerciseQuery;
import com.acme.backend.fithubpro.rutines.domain.model.queries.GetRutinesByIdQuery;

import java.util.List;
import java.util.Optional;

public interface RutinesQueryService {
    List<Rutines> handle(GetAllRutinesByExerciseQuery query);
    List<Rutines> handle(GetAllRutinesByIntructionQuery query);
    Optional<Rutines> handle(GetRutinesByIdQuery getRutinesByIdQuery);
    List<Rutines> getAllRutines();
    List<Rutines> getRutinesByCoachId(Long coachId);
}
