package com.acme.backend.fithubpro.rutines.application.internal.commandservices;


import com.acme.backend.fithubpro.rutines.domain.model.aggregate.Rutines;
import com.acme.backend.fithubpro.rutines.domain.model.commands.CreateRutineCommand;
import com.acme.backend.fithubpro.rutines.domain.services.RutinesCommandService;
import com.acme.backend.fithubpro.rutines.infrastructure.persistance.jpa.RutinesRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RutinesCommandServiceImpl implements RutinesCommandService {
    private final RutinesRepository rutinesRepository;

    public RutinesCommandServiceImpl(RutinesRepository rutinesRepository) {
        this.rutinesRepository = rutinesRepository;
    }

    @Override
    public Optional<Rutines> handle(CreateRutineCommand command) {
        var rutines = new Rutines(command);
        var createdRutines = rutinesRepository.save(rutines);
        return Optional.of(createdRutines);
    }
}
