package com.acme.backend.fithubpro.profiles.interfaces.rest.resources;

public record UpdateMemberResource(Long memberId, Long profileId, String healthGoal) {
}
