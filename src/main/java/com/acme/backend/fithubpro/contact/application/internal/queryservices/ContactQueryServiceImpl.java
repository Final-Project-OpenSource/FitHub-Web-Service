package com.acme.backend.fithubpro.contact.application.internal.queryservices;

import com.acme.backend.fithubpro.contact.domain.model.aggregate.Contact;
import com.acme.backend.fithubpro.contact.domain.services.ContactQueryService;
import com.acme.backend.fithubpro.contact.domain.model.queries.GetAllContactsQuery;
import com.acme.backend.fithubpro.contact.infrastructure.persistance.jpa.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactQueryServiceImpl implements ContactQueryService {

    private final ContactRepository contactRepository;

    public ContactQueryServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public List<Contact> handle(GetAllContactsQuery query) {
        return contactRepository.findAll();
    }
}
