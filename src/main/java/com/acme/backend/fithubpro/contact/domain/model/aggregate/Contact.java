package com.acme.backend.fithubpro.contact.domain.model.aggregate;

import com.acme.backend.fithubpro.counseling.domain.model.aggregate.BaseEntity;
import com.acme.backend.fithubpro.contact.domain.model.commands.CreateContactCommand;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Contact extends BaseEntity<Contact> {

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private Integer memberId;

    @Column(nullable = false)
    private Integer coachId;

    protected Contact() {}

    public Contact(CreateContactCommand command) {
        this.message = command.message();
        this.memberId = command.memberId();
        this.coachId = command.coachId();
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public void setCoachId(Integer coachId) {
        this.coachId = coachId;
    }
}
