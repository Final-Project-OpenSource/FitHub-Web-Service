package com.acme.backend.fithubpro.progress.application.internal.commandservices;

import com.acme.backend.fithubpro.progress.domain.model.aggregate.Progress;
import com.acme.backend.fithubpro.progress.domain.model.commands.CreateProgressCommand;
import com.acme.backend.fithubpro.progress.domain.services.ProgressCommandService;
import com.acme.backend.fithubpro.progress.infrastructure.persistence.jpa.ProgressRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProgressCommandServiceImpl implements ProgressCommandService {

    private final ProgressRepository progressRepository;

    public ProgressCommandServiceImpl(ProgressRepository progressRepository) {
        this.progressRepository = progressRepository;
    }

    @Override
    public Optional<Progress> handle(CreateProgressCommand command) {
        var progress = new Progress(command);
        var createdProgress = progressRepository.save(progress);
        return Optional.of(createdProgress);
    }
}
