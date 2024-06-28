package com.acme.backend.fithubpro.contact.domain.model.aggregate;

import com.acme.backend.fithubpro.counseling.domain.model.aggregate.BaseEntity;
import com.acme.backend.fithubpro.profiles.domain.model.aggregate.Coach;
import com.acme.backend.fithubpro.profiles.domain.model.aggregate.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
@Setter
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

}

    public void setMessage(String message) {
        this.message = message;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }
}
