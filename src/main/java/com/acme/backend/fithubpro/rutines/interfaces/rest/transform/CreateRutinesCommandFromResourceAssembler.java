package com.acme.backend.fithubpro.rutines.interfaces.rest.transform;

import com.acme.backend.fithubpro.rutines.domain.model.commands.CreateRutineCommand;
import com.acme.backend.fithubpro.rutines.interfaces.rest.resources.CreateRutinesResource;

public class CreateRutinesCommandFromResourceAssembler {
    public static CreateRutineCommand toCommandFromResource(CreateRutinesResource resource){
        return new CreateRutineCommand(resource.name(), resource.exercise(), resource.repetition(), resource.photo(), resource.instruction(), resource.coachId(), resource.memberId());
    }
}
