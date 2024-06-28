package com.acme.backend.fithubpro.profiles.domain.services;

import com.acme.backend.fithubpro.profiles.domain.model.aggregates.Coach;
import com.acme.backend.fithubpro.profiles.domain.model.queries.GetAllCoachesQuery;
import com.acme.backend.fithubpro.profiles.domain.model.queries.GetCoachByIdQuery;

import java.util.List;
import java.util.Optional;

public interface CoachQueryService {
    Optional<Coach> handle(GetCoachByIdQuery query);
    List<Coach> handle(GetAllCoachesQuery query);
}
