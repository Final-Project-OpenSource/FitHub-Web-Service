package com.acme.backend.fithubpro.profiles.interfaces.rest.resources;

public record CoachResource(Long id, Long profileId, String specialty, String certification, int yearsOfExperience) {
}
