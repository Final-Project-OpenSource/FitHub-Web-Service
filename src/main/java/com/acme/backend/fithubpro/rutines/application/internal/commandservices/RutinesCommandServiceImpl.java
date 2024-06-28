package com.acme.backend.fithubpro.rutines.application.internal.commandservices;

import com.acme.backend.fithubpro.rutines.domain.model.aggregate.Rutines;
import com.acme.backend.fithubpro.rutines.domain.model.commands.CreateRutineCommand;
import com.acme.backend.fithubpro.rutines.domain.services.RutinesCommandService;
import com.acme.backend.fithubpro.rutines.infrastructure.persistance.jpa.RutinesRepository;
import com.acme.backend.fithubpro.counseling.infrastructure.persistance.jpa.MemberRepository;
import com.acme.backend.fithubpro.counseling.infrastructure.persistance.jpa.CoachRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RutinesCommandServiceImpl implements RutinesCommandService {
    private final RutinesRepository rutinesRepository;
    private final MemberRepository memberRepository;
    private final CoachRepository coachRepository;

    public RutinesCommandServiceImpl(RutinesRepository rutinesRepository, MemberRepository memberRepository, CoachRepository coachRepository) {
        this.rutinesRepository = rutinesRepository;
        this.memberRepository = memberRepository;
        this.coachRepository = coachRepository;
    }

    @Override
    public Optional<Rutines> handle(CreateRutineCommand command) {
        var member = memberRepository.findById(command.memberId())
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
        var coach = coachRepository.findById(command.coachId())
                .orElseThrow(() -> new IllegalArgumentException("Coach not found"));

        Rutines rutines = new Rutines(command);
        rutines.setMember(member);
        rutines.setCoach(coach);

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
