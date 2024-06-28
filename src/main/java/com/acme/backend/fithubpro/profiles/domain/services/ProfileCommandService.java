package com.acme.backend.fithubpro.profiles.domain.services;

import com.acme.backend.fithubpro.profiles.domain.model.aggregates.Profile;
import com.acme.backend.fithubpro.profiles.domain.model.commands.CreateProfileCommand;

import java.util.Optional;

public interface ProfileCommandService {
    Optional<Profile> handle(CreateProfileCommand command);
}
