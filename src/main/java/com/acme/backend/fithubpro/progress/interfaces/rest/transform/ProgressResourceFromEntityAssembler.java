package com.acme.backend.fithubpro.progress.interfaces.rest.transform;

import com.acme.backend.fithubpro.progress.domain.model.aggregate.Progress;
import com.acme.backend.fithubpro.progress.interfaces.rest.resources.ProgressResource;

public final class ProgressResourceFromEntityAssembler {

    private ProgressResourceFromEntityAssembler() {}

    public static ProgressResource toResourceFromEntity(Progress entity) {
        return new ProgressResource(entity.getId(), entity.getContent(), entity.getDate(), entity.getClientId(), entity.getCoachId());
    }
}
