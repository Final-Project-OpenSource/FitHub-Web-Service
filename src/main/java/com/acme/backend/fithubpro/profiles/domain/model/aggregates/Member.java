package com.acme.backend.fithubpro.profiles.domain.model.aggregates;

import com.acme.backend.fithubpro.counseling.domain.model.aggregate.BaseEntity;
import com.acme.backend.fithubpro.profiles.domain.model.commands.CreateMemberCommand;
import com.acme.backend.fithubpro.profiles.domain.model.commands.UpdateMemberCommand;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Member extends BaseEntity<Member> {

    @Column(nullable = false)
    private String healthGoal;

    @Column(name = "profile_id", insertable = false, updatable = false)
    private Long profileId;

    @OneToOne
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    protected Member() {
    }

    public Member(CreateMemberCommand command, Profile profile) {
        this.healthGoal = command.healthGoal();
        this.profileId = command.profileId();
        this.profile = profile;
    }

    public Member(UpdateMemberCommand command) {
        this.healthGoal = command.healthGoal();
        this.profileId = command.profileId();
    }
}
