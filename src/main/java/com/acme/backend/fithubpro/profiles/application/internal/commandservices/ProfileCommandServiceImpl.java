package com.acme.backend.fithubpro.profiles.application.internal.commandservices;

import com.acme.backend.fithubpro.profiles.domain.model.aggregates.Profile;
import com.acme.backend.fithubpro.profiles.domain.model.commands.CreateProfileCommand;
import com.acme.backend.fithubpro.profiles.domain.model.commands.UpdateProfileCommand;
import com.acme.backend.fithubpro.profiles.domain.model.valueobjects.EmailAddress;
import com.acme.backend.fithubpro.profiles.domain.services.ProfileCommandService;
import com.acme.backend.fithubpro.profiles.infrastructure.persistence.jpa.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileCommandServiceImpl implements ProfileCommandService {
    private final ProfileRepository profileRepository;

    public ProfileCommandServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Optional<Profile> handle(CreateProfileCommand command) {
        var emailAddress = new EmailAddress(command.email());
        profileRepository.findByEmail(emailAddress).map(profile -> {
            throw new IllegalArgumentException("Profile with email " + command.email() + " already exists");
        });
        var profile = new Profile(command);
        profileRepository.save(profile);
        return Optional.of(profile);
    }

    @Override
    public Optional<Profile> handle(UpdateProfileCommand command) {
        var emailAddress = new EmailAddress(command.email());
        var profile = profileRepository.findByEmail(emailAddress).orElseThrow(() -> new IllegalArgumentException("Profile with email " + command.email() + " does not exist"));

        var newEmailAddress = new EmailAddress(command.email());
        var existingProfileWithNewEmail = profileRepository.findByEmail(newEmailAddress);
        if (existingProfileWithNewEmail.isPresent() && !existingProfileWithNewEmail.get().equals(profile)) {
            throw new IllegalArgumentException("Email " + command.email() + " is already in use");
        }

        profile.updateName(command.firstName(), command.lastName());
        profile.updateEmail(command.email());
        profile.updateAddress(command.street(), command.number(), command.city(), command.postalCode(), command.country());
        profile.updateProfileImageUrl(command.profileImageUrl());
        profileRepository.save(profile);
        return Optional.of(profile);
    }
}
