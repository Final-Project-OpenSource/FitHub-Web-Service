package com.acme.backend.fithubpro.subscription.aplication.internal.commandservices;

import com.acme.backend.fithubpro.subscription.domain.model.aggregates.Membership;
import com.acme.backend.fithubpro.subscription.domain.model.commands.CreateMembershipCommand;
import com.acme.backend.fithubpro.subscription.domain.services.MembershipCommandService;
import com.acme.backend.fithubpro.subscription.infraestructure.persistance.jpa.MembershipRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MembershipCommandServiceImpl implements MembershipCommandService {

    private final MembershipRepository membershipRepository;

    public MembershipCommandServiceImpl(MembershipRepository membershipRepository) {
        this.membershipRepository = membershipRepository;
    }

    @Override
    public Optional<Membership> handle(CreateMembershipCommand command) {
        // Aquí va la lógica para manejar el comando CreateMembershipCommand

        // y devolver un Optional<Membership>
        return Optional.empty();
    }

}