package com.acme.backend.fithubpro.profiles.application.internal.commandservices;


import com.acme.backend.fithubpro.profiles.domain.model.aggregates.Coach;
import com.acme.backend.fithubpro.profiles.domain.model.aggregates.Profile;
import com.acme.backend.fithubpro.profiles.domain.model.commands.CreateCoachCommand;
import com.acme.backend.fithubpro.profiles.domain.model.commands.UpdateCoachCommand;
import com.acme.backend.fithubpro.profiles.domain.services.CoachCommandService;
import com.acme.backend.fithubpro.profiles.infrastructure.persistence.jpa.repositories.CoachRepository;
import com.acme.backend.fithubpro.profiles.infrastructure.persistence.jpa.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CoachCommandServiceImpl implements CoachCommandService {

    private final CoachRepository coachRepository;
    private final ProfileRepository profileRepository;

    public CoachCommandServiceImpl(CoachRepository coachRepository, ProfileRepository profileRepository) {
        this.coachRepository = coachRepository;
        this.profileRepository = profileRepository;
    }

    @Override
    public Optional<Coach> handle(CreateCoachCommand command) {
        Profile profile = profileRepository.findById(command.profileId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid profile ID"));

        Coach coach = new Coach(command, profile);
        coach = coachRepository.save(coach);
        return Optional.of(coach);
    }

    @Override
    public Optional<Coach> handle(UpdateCoachCommand command) {
        Coach coach = coachRepository.findById(command.coachId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid coach ID"));

        coach.setSpecialty(command.specialty());
        coach.setCertification(command.certification());
        coach.setYearsOfExperience(command.yearsOfExperience());
        coach.setProfileId(command.profileId());

        coach = coachRepository.save(coach);
        return Optional.of(coach);
    }
}

