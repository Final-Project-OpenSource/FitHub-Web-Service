package com.acme.backend.fithubpro.progress.application.internal.queryservices;

import com.acme.backend.fithubpro.progress.domain.model.aggregate.Progress;
import com.acme.backend.fithubpro.progress.domain.services.ProgressQueryService;
import com.acme.backend.fithubpro.progress.domain.model.queries.GetAllProgressByClientIdQuery;
import com.acme.backend.fithubpro.progress.domain.model.queries.GetProgressByIdAndClientIdQuery;
import com.acme.backend.fithubpro.progress.infrastructure.persistence.jpa.ProgressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgressQueryServiceImpl implements ProgressQueryService {

    private final ProgressRepository progressRepository;

    public ProgressQueryServiceImpl(ProgressRepository progressRepository) {
        this.progressRepository = progressRepository;
    }

    @Override
    public List<Progress> handle(GetAllProgressByClientIdQuery query) {
        return progressRepository.findAllByClientId(query.clientId());
    }

    @Override
    public Optional<Progress> handle(GetProgressByIdAndClientIdQuery query) {
        return progressRepository.findByIdAndClientId(query.id(), query.clientId());
    }
}
