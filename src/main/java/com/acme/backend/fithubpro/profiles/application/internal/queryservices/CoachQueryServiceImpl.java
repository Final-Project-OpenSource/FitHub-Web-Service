package com.acme.backend.fithubpro.profiles.application.internal.queryservices;

import com.acme.backend.fithubpro.profiles.domain.model.aggregates.Coach;
import com.acme.backend.fithubpro.profiles.domain.model.queries.GetAllCoachesQuery;
import com.acme.backend.fithubpro.profiles.domain.model.queries.GetCoachByIdQuery;
import com.acme.backend.fithubpro.profiles.domain.services.CoachQueryService;
import com.acme.backend.fithubpro.profiles.infrastructure.persistence.jpa.repositories.CoachRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoachQueryServiceImpl implements CoachQueryService {
    private final CoachRepository coachRepository;

    public CoachQueryServiceImpl(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    @Override
    public Optional<Coach> handle(GetCoachByIdQuery query) {
        return coachRepository.findById(query.coachId());
    }

    @Override
    public List<Coach> handle(GetAllCoachesQuery query) {
        return coachRepository.findAll();
    }
}
