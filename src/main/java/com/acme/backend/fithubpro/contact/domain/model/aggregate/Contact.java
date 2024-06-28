package com.acme.backend.fithubpro.contact.domain.model.aggregate;

import com.acme.backend.fithubpro.counseling.domain.model.aggregate.BaseEntity;
import com.acme.backend.fithubpro.profiles.domain.model.aggregates.Coach;
import com.acme.backend.fithubpro.profiles.domain.model.aggregates.Member;
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

    @OneToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "coach_id", nullable = false)
    private Coach coach;

    protected Contact() {}

    public Contact(CreateContactCommand command) {
        this.message = command.message();
        this.member = null;
        this.coach = null;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }
}
