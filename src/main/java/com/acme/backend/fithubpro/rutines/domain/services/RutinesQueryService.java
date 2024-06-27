package com.acme.backend.fithubpro.rutines.domain.services;

import com.acme.backend.fithubpro.rutines.domain.model.aggregate.Rutines;
import com.acme.backend.fithubpro.rutines.domain.model.queries.GetAllRutinesBynameQuery;
import com.acme.backend.fithubpro.rutines.domain.model.queries.GetRutinesByIdQuery;

import java.util.List;
import java.util.Optional;

public interface RutinesQueryService {
    List<Rutines> handle(GetAllRutinesBynameQuery query);


    Optional<Rutines> handle(GetRutinesByIdQuery query);
}
