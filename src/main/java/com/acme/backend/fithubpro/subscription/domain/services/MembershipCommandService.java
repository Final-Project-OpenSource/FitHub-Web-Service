package com.acme.backend.fithubpro.subscription.domain.services;

import com.acme.backend.fithubpro.subscription.domain.model.aggregates.Membership;
import com.acme.backend.fithubpro.subscription.domain.model.commands.CreateMembershipCommand;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface MembershipCommandService {
    Optional<Membership> handle(CreateMembershipCommand command);
}

