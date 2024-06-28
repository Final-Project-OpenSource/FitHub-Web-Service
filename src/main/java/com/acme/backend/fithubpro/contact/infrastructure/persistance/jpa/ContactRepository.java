package com.acme.backend.fithubpro.contact.infrastructure.persistence.jpa;

import com.acme.backend.fithubpro.contact.domain.model.aggregate.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findAllByCoachId(Long coachId);
    Contact findByMemberId(Long memberId);
}
