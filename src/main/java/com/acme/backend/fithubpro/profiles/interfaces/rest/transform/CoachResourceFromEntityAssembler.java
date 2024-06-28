package com.acme.backend.fithubpro.profiles.interfaces.rest.transform;

import com.acme.backend.fithubpro.profiles.domain.model.aggregates.Coach;
import com.acme.backend.fithubpro.profiles.interfaces.rest.resources.CoachResource;

public class CoachResourceFromEntityAssembler {
    public static CoachResource toResourceFromEntity(Coach entity) {
        return new CoachResource(entity.getId(), entity.getProfileId(), entity.getSpecialty(), entity.getCertification(), entity.getYearsOfExperience());
    }
}