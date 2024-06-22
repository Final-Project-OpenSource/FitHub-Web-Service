package com.acme.backend.fithubpro.progress.domain.services;

import com.acme.backend.fithubpro.progress.domain.model.aggregate.Progress;
import com.acme.backend.fithubpro.progress.domain.model.queries.GetAllProgressByClientIdQuery;
import com.acme.backend.fithubpro.progress.domain.model.queries.GetProgressByIdAndClientIdQuery;

import java.util.List;
import java.util.Optional;

public interface ProgressQueryService {
    List<Progress> handle(GetAllProgressByClientIdQuery query);
    Optional<Progress> handle(GetProgressByIdAndClientIdQuery query);
}
