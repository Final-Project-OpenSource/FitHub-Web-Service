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
        Rutines rutines = new Rutines(command);
        return Optional.of(rutinesRepository.save(rutines));
    }

    @Override
    public Optional<Rutines> update(Long id, CreateRutineCommand command) {
        Optional<Rutines> existingRutine = rutinesRepository.findById(id);
        if (existingRutine.isPresent()) {
            Rutines rutine = existingRutine.get();
            rutine.setName(command.name());
            rutine.setExercise(command.exercise());
            rutine.setRepetition(command.repetition());
            rutine.setPhoto(command.photo());
            rutine.setInstruction(command.instruction());
            rutine.setCoachId(command.coachId());
            rutine.setMemberId(command.memberId());
            return Optional.of(rutinesRepository.save(rutine));
        }
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        rutinesRepository.deleteById(id);
    }
}
