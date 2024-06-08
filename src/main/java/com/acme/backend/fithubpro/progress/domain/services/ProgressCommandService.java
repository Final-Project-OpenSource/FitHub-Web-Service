package com.acme.backend.fithubpro.progress.domain.services;

import com.acme.backend.fithubpro.progress.domain.model.aggregate.Progress;
import com.acme.backend.fithubpro.progress.domain.model.commands.CreateProgressCommand;

import java.util.Optional;

public interface ProgressCommandService {
    Optional<Progress> handle(CreateProgressCommand command);
}
