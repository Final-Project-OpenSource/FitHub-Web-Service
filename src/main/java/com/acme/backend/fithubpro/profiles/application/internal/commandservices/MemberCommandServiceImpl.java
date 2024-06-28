package com.acme.backend.fithubpro.profiles.application.internal.commandservices;

import com.acme.backend.fithubpro.profiles.domain.model.aggregates.Member;
import com.acme.backend.fithubpro.profiles.domain.model.aggregates.Profile;
import com.acme.backend.fithubpro.profiles.domain.model.commands.CreateMemberCommand;
import com.acme.backend.fithubpro.profiles.domain.model.commands.UpdateMemberCommand;
import com.acme.backend.fithubpro.profiles.domain.services.MemberCommandService;
import com.acme.backend.fithubpro.profiles.infrastructure.persistence.jpa.repositories.MemberRepository;
import com.acme.backend.fithubpro.profiles.infrastructure.persistence.jpa.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final ProfileRepository profileRepository;

    public MemberCommandServiceImpl(MemberRepository memberRepository, ProfileRepository profileRepository) {
        this.memberRepository = memberRepository;
        this.profileRepository = profileRepository;
    }

    @Override
    public Optional<Member> handle(CreateMemberCommand command) {
        Profile profile = profileRepository.findById(command.profileId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid profile ID"));

        Member member = new Member(command, profile);
        member = memberRepository.save(member);
        return Optional.of(member);
    }

    @Override
    public Optional<Member> handle(UpdateMemberCommand command) {
        Member member = memberRepository.findById(command.memberId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid member ID"));

        member.setHealthGoal(command.healthGoal());

        member = memberRepository.save(member);
        return Optional.of(member);
    }
}
