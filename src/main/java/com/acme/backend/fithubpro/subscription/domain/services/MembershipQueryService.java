package com.acme.backend.fithubpro.subscription.domain.services;

import com.acme.backend.fithubpro.subscription.domain.model.aggregates.Membership;
import com.acme.backend.fithubpro.subscription.domain.model.queries.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MembershipQueryService {
    List<Membership> handle (GetAllMembershipByBenefitsQuery query);

    List<Membership> handle (GetAllMembershipByPriceQuery query);

    List<Membership> handle (GetAllMembershipByTypeQuery query);

    Optional<Membership> handle (GetAllMembershipByTypeAndBenefitsQuery query);
}
