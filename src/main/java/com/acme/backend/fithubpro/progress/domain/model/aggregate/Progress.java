package com.acme.backend.fithubpro.progress.domain.model.aggregate;

import com.acme.backend.fithubpro.counseling.domain.model.aggregate.BaseEntity;
import com.acme.backend.fithubpro.profiles.domain.model.aggregates.Coach;
import com.acme.backend.fithubpro.profiles.domain.model.aggregates.Member;
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

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "coach_id", nullable = false)
    private Coach coach;

    protected Progress() {}

    public Progress(CreateProgressCommand command) {
        this.content = command.content();
        this.date = command.date();
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }
}
