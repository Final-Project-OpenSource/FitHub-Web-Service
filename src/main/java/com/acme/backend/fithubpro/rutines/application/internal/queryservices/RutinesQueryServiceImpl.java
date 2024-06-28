package com.acme.backend.fithubpro.rutines.application.internal.queryservices;

import com.acme.backend.fithubpro.rutines.domain.model.aggregate.Rutines;
import com.acme.backend.fithubpro.rutines.domain.model.queries.GetAllRutinesByExerciseQuery;
import com.acme.backend.fithubpro.rutines.domain.model.queries.GetAllRutinesByIntructionQuery;
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
    public List<Rutines> handle(GetAllRutinesByExerciseQuery query) {
        return rutinesRepository.findAllByExercise(query.exercise());
    }

    @Override
    public List<Rutines> handle(GetAllRutinesByIntructionQuery query) {
        return rutinesRepository.findAllByInstruction(query.instruction());
    }

    @Override
    public Optional<Rutines> handle(GetRutinesByIdQuery getRutinesByIdQuery) {
        return rutinesRepository.findById(getRutinesByIdQuery.id());
    }

    @Override
    public List<Rutines> getAllRutines() {
        return rutinesRepository.findAll();
    }

    @Override
    public List<Rutines> getRutinesByCoachId(Long coachId) {
        return rutinesRepository.findAllByCoachId(coachId);
    }
}
