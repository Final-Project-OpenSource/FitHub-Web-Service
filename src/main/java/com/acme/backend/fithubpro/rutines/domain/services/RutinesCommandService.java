package com.acme.backend.fithubpro.rutines.domain.services;

import com.acme.backend.fithubpro.rutines.domain.model.aggregate.Rutines;
import com.acme.backend.fithubpro.rutines.domain.model.commands.CreateRutineCommand;

import java.util.Optional;

public interface RutinesCommandService {
    Optional<Rutines> handle(CreateRutineCommand command);
}
