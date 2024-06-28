package com.acme.backend.fithubpro.profiles.domain.services;

import com.acme.backend.fithubpro.profiles.domain.model.aggregates.Member;
import com.acme.backend.fithubpro.profiles.domain.model.commands.CreateMemberCommand;
import com.acme.backend.fithubpro.profiles.domain.model.commands.UpdateMemberCommand;

import java.util.Optional;

public interface MemberCommandService {
    Optional<Member> handle(CreateMemberCommand command);
    Optional<Member> handle(UpdateMemberCommand command);
}
