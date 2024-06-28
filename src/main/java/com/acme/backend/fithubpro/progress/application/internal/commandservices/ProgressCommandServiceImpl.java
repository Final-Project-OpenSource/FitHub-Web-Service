package com.acme.backend.fithubpro.progress.application.internal.commandservices;

import com.acme.backend.fithubpro.progress.domain.model.aggregate.Progress;
import com.acme.backend.fithubpro.progress.domain.model.commands.CreateProgressCommand;
import com.acme.backend.fithubpro.progress.domain.services.ProgressCommandService;
import com.acme.backend.fithubpro.progress.infrastructure.persistence.jpa.ProgressRepository;
import com.acme.backend.fithubpro.counseling.infraestructure.persistance.jpa.MemberRepository;
import com.acme.backend.fithubpro.counseling.infraestructure.persistance.jpa.CoachRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProgressCommandServiceImpl implements ProgressCommandService {

    private final ProgressRepository progressRepository;
    private final MemberRepository memberRepository;
    private final CoachRepository coachRepository;

    public ProgressCommandServiceImpl(ProgressRepository progressRepository, MemberRepository memberRepository, CoachRepository coachRepository) {
        this.progressRepository = progressRepository;
        this.memberRepository = memberRepository;
        this.coachRepository = coachRepository;
    }

    @Override
    public Optional<Progress> handle(CreateProgressCommand command) {
        var member = memberRepository.findById(command.memberId())
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
        var coach = coachRepository.findById(command.coachId())
                .orElseThrow(() -> new IllegalArgumentException("Coach not found"));

        var progress = new Progress(command);
        progress.setMember(member);
        progress.setCoach(coach);

        var createdProgress = progressRepository.save(progress);
        return Optional.of(createdProgress);
    }

    @Override
    public Optional<Progress> update(Long id, CreateProgressCommand command) {
        Optional<Progress> existingProgress = progressRepository.findById(id);
        if (existingProgress.isPresent()) {
            Progress progress = existingProgress.get();
            progress.setContent(command.content());
            progress.setDate(command.date());
            progress.setMemberId(command.memberId());
            progress.setCoachId(command.coachId());
            return Optional.of(progressRepository.save(progress));
        }
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        progressRepository.deleteById(id);
    }
}
