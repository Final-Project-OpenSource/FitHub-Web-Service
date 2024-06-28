package com.acme.backend.fithubpro.rutines.domain.model.aggregate;

import com.acme.backend.fithubpro.counseling.domain.model.aggregate.BaseEntity;
import com.acme.backend.fithubpro.counseling.domain.model.aggregate.Coach;
import com.acme.backend.fithubpro.counseling.domain.model.aggregate.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
@Setter
@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Rutines extends BaseEntity<Rutines> {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String exercise;

    @Column(nullable = false)
    private String repetition;

    @Column(nullable = false)
    private String photo;

    @Column(nullable = false)
    private String instruction;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "coach_id", nullable = false)
    private Coach coach;

    protected Rutines() {}

    public Rutines(CreateRutineCommand command, Coach coach) {
        this.name = command.name();
        this.exercise = command.exercise();
        this.repetition = command.repetition();
        this.photo = command.photo();
        this.instruction = command.instruction();
        this.coach = coach;
    }
}
