package com.acme.backend.fithubpro.rutines.domain.model.aggregate;

import com.acme.backend.fithubpro.counseling.domain.model.aggregate.BaseEntity;
import com.acme.backend.fithubpro.rutines.domain.model.commands.CreateRutineCommand;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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

    @Column(nullable = false)
    private Long coachId;

    @Column(nullable = true)
    private Long memberId;

    protected Rutines() {
    }

    public Rutines(CreateRutineCommand command) {
        this.name = command.name();
        this.exercise = command.exercise();
        this.repetition = command.repetition();
        this.photo = command.photo();
        this.instruction = command.instruction();
        this.coachId = command.coachId();
        this.memberId = command.memberId();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public void setRepetition(String repetition) {
        this.repetition = repetition;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public void setCoachId(Long coachId) {
        this.coachId = coachId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
}
