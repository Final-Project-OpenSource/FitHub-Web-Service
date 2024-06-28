package com.acme.backend.fithubpro.contact.interfaces.rest.transform;

import com.acme.backend.fithubpro.contact.domain.model.aggregate.Contact;
import com.acme.backend.fithubpro.contact.interfaces.rest.resources.ContactResource;

public final class ContactResourceFromEntityAssembler {

    private ContactResourceFromEntityAssembler() {}

    public static ContactResource toResourceFromEntity(Contact entity) {
        return new ContactResource(entity.getId(), entity.getMessage(), entity.getMemberId(), entity.getCoachId());
    }
}
