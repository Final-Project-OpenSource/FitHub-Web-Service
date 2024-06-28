package com.acme.backend.fithubpro.profiles.interfaces.rest.resources;

public record UpdateCoachResource(Long coachId, Long profileId, String specialty, String certification, int yearsOfExperience) {
}
