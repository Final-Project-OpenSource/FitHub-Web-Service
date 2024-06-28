package com.acme.backend.fithubpro.profiles.domain.model.commands;

import com.acme.backend.fithubpro.profiles.domain.model.aggregates.Profile;

public record UpdateMemberCommand(Long memberId, Long profileId, String healthGoal) {
    public UpdateMemberCommand {
        if (memberId == null) {
            throw new IllegalArgumentException("MemberId must not be null.");
        }
        if (profileId == null) {
            throw new IllegalArgumentException("ProfileId must not be null.");
        }
        if (healthGoal == null || healthGoal.isBlank()) {
            throw new IllegalArgumentException("Health goal must not be null or empty.");
        }
    }
}
