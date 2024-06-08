package com.acme.backend.fithubpro.progress.domain.model.aggregate;

import com.acme.backend.fithubpro.counseling.domain.model.aggregate.BaseEntity;
import com.acme.backend.fithubpro.progress.domain.model.commands.CreateProgressCommand;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Progress extends BaseEntity<Progress> {

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private Integer clientId;

    protected Progress() {}

    public Progress(CreateProgressCommand command) {
        this.content = command.content();
        this.date = command.date();
        this.clientId = command.clientId();
    }
}
