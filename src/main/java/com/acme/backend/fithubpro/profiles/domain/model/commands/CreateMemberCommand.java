package com.acme.backend.fithubpro.profiles.domain.model.commands;

import com.acme.backend.fithubpro.profiles.domain.model.aggregates.Profile;

public record CreateMemberCommand(Long profileId, String healthGoal) {
    public CreateMemberCommand {
        if (profileId == null) {
            throw new IllegalArgumentException("ProfileId must not be null.");
        }
        if (healthGoal == null || healthGoal.isBlank()) {
            throw new IllegalArgumentException("Health goal must not be null or empty.");
        }
    }
}
