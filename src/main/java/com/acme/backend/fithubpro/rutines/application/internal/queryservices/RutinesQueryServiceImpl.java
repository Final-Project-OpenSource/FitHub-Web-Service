package com.acme.backend.fithubpro.rutines.application.internal.queryservices;

import com.acme.backend.fithubpro.rutines.domain.model.aggregate.Rutines;
import com.acme.backend.fithubpro.rutines.domain.model.queries.GetAllRutinesBynameQuery;
import com.acme.backend.fithubpro.rutines.domain.model.queries.GetRutinesByIdQuery;
import com.acme.backend.fithubpro.rutines.domain.services.RutinesQueryService;
import com.acme.backend.fithubpro.rutines.infrastructure.persistance.jpa.RutinesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RutinesQueryServiceImpl implements RutinesQueryService {
    private final RutinesRepository rutinesRepository;

    public RutinesQueryServiceImpl(RutinesRepository rutinesRepository) {
        this.rutinesRepository = rutinesRepository;
    }

    @Override
    public List<Rutines> handle(GetAllRutinesBynameQuery query) {
        return rutinesRepository.findAllByName(query.name());
    }

    @Override
    public Optional<Rutines> handle(GetRutinesByIdQuery query) {

        return rutinesRepository.findById(query.id());
    }
}
