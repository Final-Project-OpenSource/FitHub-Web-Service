package com.acme.backend.fithubpro.rutines.domain.services;

import com.acme.backend.fithubpro.rutines.domain.model.aggregate.Rutines;
import com.acme.backend.fithubpro.rutines.domain.model.queries.GetAllRutinesByIntructionQuery;
import com.acme.backend.fithubpro.rutines.domain.model.queries.GetAllRutinesByexerciseQuery;

import java.util.List;

public interface RutinesQueryService {
    List<Rutines> handle(GetAllRutinesByexerciseQuery query);

    List<Rutines> handle(GetAllRutinesByIntructionQuery query);
}
