package com.acme.backend.fithubpro.contact.application.internal.commandservices;

import com.acme.backend.fithubpro.contact.domain.model.aggregate.Contact;
import com.acme.backend.fithubpro.contact.domain.model.commands.CreateContactCommand;
import com.acme.backend.fithubpro.contact.domain.services.ContactCommandService;
import com.acme.backend.fithubpro.contact.infrastructure.persistance.jpa.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactCommandServiceImpl implements ContactCommandService {

    private final ContactRepository contactRepository;

    public ContactCommandServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Optional<Contact> handle(CreateContactCommand command) {
        var contact = new Contact(command);
        var createdContact = contactRepository.save(contact);
        return Optional.of(createdContact);
    }
}
