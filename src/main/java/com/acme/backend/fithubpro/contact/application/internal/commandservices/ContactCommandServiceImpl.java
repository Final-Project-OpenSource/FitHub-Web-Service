package com.acme.backend.fithubpro.contact.application.internal.commandservices;

import com.acme.backend.fithubpro.contact.domain.model.aggregate.Contact;
import com.acme.backend.fithubpro.contact.domain.model.commands.CreateContactCommand;
import com.acme.backend.fithubpro.contact.domain.services.ContactCommandService;
import com.acme.backend.fithubpro.contact.infrastructure.persistence.jpa.ContactRepository;
import com.acme.backend.fithubpro.profiles.infrastructure.persistence.jpa.repositories.MemberRepository;
import com.acme.backend.fithubpro.profiles.infrastructure.persistence.jpa.repositories.CoachRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactCommandServiceImpl implements ContactCommandService {

    private final ContactRepository contactRepository;
    private final MemberRepository memberRepository;
    private final CoachRepository coachRepository;

    public ContactCommandServiceImpl(ContactRepository contactRepository, MemberRepository memberRepository, CoachRepository coachRepository) {
        this.contactRepository = contactRepository;
        this.memberRepository = memberRepository;
        this.coachRepository = coachRepository;
    }

    @Override
    public Optional<Contact> handle(CreateContactCommand command) {
        var member = memberRepository.findById(command.memberId().longValue())
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
        var coach = coachRepository.findById(command.coachId().longValue())
                .orElseThrow(() -> new IllegalArgumentException("Coach not found"));

        var contact = new Contact(command);
        contact.setMember(member);
        contact.setCoach(coach);

        var createdContact = contactRepository.save(contact);
        return Optional.of(createdContact);
    }
}
