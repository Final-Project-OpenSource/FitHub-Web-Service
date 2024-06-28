package com.acme.backend.fithubpro.contact.domain.services;

import com.acme.backend.fithubpro.contact.domain.model.aggregate.Contact;
import com.acme.backend.fithubpro.contact.domain.model.queries.GetAllContactsQuery;
import java.util.List;

public interface ContactQueryService {
    List<Contact> handle(GetAllContactsQuery query);
}
