package com.acme.backend.fithubpro.profiles.domain.services;

import com.acme.backend.fithubpro.profiles.domain.model.aggregates.Coach;
import com.acme.backend.fithubpro.profiles.domain.model.commands.CreateCoachCommand;
import com.acme.backend.fithubpro.profiles.domain.model.commands.UpdateCoachCommand;

import java.util.Optional;

public interface CoachCommandService {
    Optional<Coach> handle(CreateCoachCommand command);
    Optional<Coach> handle(UpdateCoachCommand command);
}
