package com.acme.backend.fithubpro.rutines.interfaces.rest.transform;

import com.acme.backend.fithubpro.rutines.domain.model.commands.CreateRutineCommand;
import com.acme.backend.fithubpro.rutines.interfaces.rest.resources.CreateRutinesREsource;

public class CreateRutinescommandFromResourceAssembler {
    public static CreateRutineCommand toCommandFromResource(CreateRutinesREsource resource){
        return new CreateRutineCommand(resource.name(), resource.exercise(), resource.repetition(), resource.photo(), resource.instruction());
    }
}
