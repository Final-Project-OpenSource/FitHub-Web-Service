package com.acme.backend.fithubpro.profiles.interfaces.rest.resources;

public record CreateCoachResource(Long profileId, String specialty, String certification, int yearsOfExperience) {
}
