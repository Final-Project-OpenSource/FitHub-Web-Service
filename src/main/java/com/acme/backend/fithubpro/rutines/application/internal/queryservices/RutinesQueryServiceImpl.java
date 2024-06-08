package com.acme.backend.fithubpro.rutines.application.internal.queryservices;

import com.acme.backend.fithubpro.rutines.domain.model.aggregate.Rutines;
import com.acme.backend.fithubpro.rutines.domain.model.queries.GetAllRutinesByIntructionQuery;
import com.acme.backend.fithubpro.rutines.domain.model.queries.GetAllRutinesByexerciseQuery;
import com.acme.backend.fithubpro.rutines.domain.services.RutinesQueryService;
import com.acme.backend.fithubpro.rutines.infrastructure.persistance.jpa.RutinesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutinesQueryServiceImpl implements RutinesQueryService {
    private final RutinesRepository rutinesRepository;

    public RutinesQueryServiceImpl(RutinesRepository rutinesRepository) {
        this.rutinesRepository = rutinesRepository;
    }

    @Override
    public List<Rutines> handle(GetAllRutinesByexerciseQuery query) {
        return null;
    }

    @Override
    public List<Rutines> handle(GetAllRutinesByIntructionQuery query) {
        return null;
    }
}
