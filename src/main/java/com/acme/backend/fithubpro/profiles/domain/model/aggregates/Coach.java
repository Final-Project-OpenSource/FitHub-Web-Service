package com.acme.backend.fithubpro.profiles.domain.model.aggregates;

import com.acme.backend.fithubpro.counseling.domain.model.aggregate.BaseEntity;
import com.acme.backend.fithubpro.profiles.domain.model.commands.CreateCoachCommand;
import com.acme.backend.fithubpro.profiles.domain.model.commands.UpdateCoachCommand;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Setter
@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Coach extends BaseEntity<Coach> {

    @Column(nullable = false)
    private String specialty;

    @Column(nullable = false)
    private String certification;

    @Column(nullable = false)
    private int yearsOfExperience;

    @Column(name = "profile_id", insertable = false, updatable = false)
    private Long profileId;

    @OneToOne
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    protected Coach() {
    }

    public Coach(CreateCoachCommand command, Profile profile) {
        this.specialty = command.specialty();
        this.certification = command.certification();
        this.yearsOfExperience = command.yearsOfExperience();
        this.profileId = command.profileId();
        this.profile = profile;
    }
    public Coach(UpdateCoachCommand command) {
        this.specialty = command.specialty();
        this.certification = command.certification();
        this.yearsOfExperience = command.yearsOfExperience();
        this.profileId = command.profileId();
    }


}

