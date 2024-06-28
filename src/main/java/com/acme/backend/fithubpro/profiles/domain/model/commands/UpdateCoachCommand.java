package com.acme.backend.fithubpro.profiles.domain.model.commands;

import com.acme.backend.fithubpro.profiles.domain.model.aggregates.Profile;

public record UpdateCoachCommand(Long coachId, Long profileId, String specialty, String certification, int yearsOfExperience){
    public UpdateCoachCommand {
        if (coachId == null) {
            throw new IllegalArgumentException("CoachId must not be null.");
        }
        if (profileId == null) {
            throw new IllegalArgumentException("ProfileId must not be null.");
        }
        if (specialty == null || specialty.isBlank()) {
            throw new IllegalArgumentException("Specialty must not be null or empty.");
        }
        if (certification == null || certification.isBlank()) {
            throw new IllegalArgumentException("Certification must not be null or empty.");
        }
        if (yearsOfExperience < 0) {
            throw new IllegalArgumentException("Years of experience must not be negative.");
        }
    }
}
