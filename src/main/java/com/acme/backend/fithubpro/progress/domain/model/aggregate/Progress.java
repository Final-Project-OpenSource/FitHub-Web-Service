package com.acme.backend.fithubpro.progress.domain.model.aggregate;

import com.acme.backend.fithubpro.counseling.domain.model.aggregate.BaseEntity;
import com.acme.backend.fithubpro.profiles.domain.model.aggregate.Coach;
import com.acme.backend.fithubpro.profiles.domain.model.aggregate.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
@Setter
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

    public Progress(CreateProgressCommand command, Member member, Coach coach) {
        this.content = command.content();
        this.date = command.date();
        this.member = member;
        this.coach = coach;
    }
}
