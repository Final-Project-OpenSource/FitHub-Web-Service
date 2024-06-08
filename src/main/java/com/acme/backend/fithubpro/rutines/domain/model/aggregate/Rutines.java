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

    protected Rutines(){

    }

    public Rutines (CreateRutineCommand command){
        this.name = command.name();
        this.exercise = command.exercise();
        this.repetition = command.repetition();
        this.photo = command.photo();
        this.instruction = command.instruction();
    }
}
