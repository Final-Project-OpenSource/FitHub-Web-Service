package com.acme.backend.fithubpro.contact.domain.services;

import com.acme.backend.fithubpro.contact.domain.model.aggregate.Contact;
import com.acme.backend.fithubpro.contact.domain.model.commands.CreateContactCommand;
import java.util.Optional;

public interface ContactCommandService {
    Optional<Contact> handle(CreateContactCommand command);
}
