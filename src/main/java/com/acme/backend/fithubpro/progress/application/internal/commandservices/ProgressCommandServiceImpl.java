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

    @Override
    public Optional<Progress> update(Long id, CreateProgressCommand command) {
        Optional<Progress> existingProgress = progressRepository.findById(id);
        if (existingProgress.isPresent()) {
            Progress progress = existingProgress.get();
            progress.setContent(command.content());
            progress.setDate(command.date());
            progress.setClientId(command.clientId());
            progress.setCoachId(command.coachId());
            return Optional.of(progressRepository.save(progress));
        }
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        progressRepository.deleteById(id);
    }
}
