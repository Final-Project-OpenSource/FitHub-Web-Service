package com.acme.backend.fithubpro.subscription.aplication.internal.queryservices;

import com.acme.backend.fithubpro.subscription.domain.model.aggregates.Membership;
import com.acme.backend.fithubpro.subscription.domain.model.queries.GetAllMembershipByBenefitsQuery;
import com.acme.backend.fithubpro.subscription.domain.model.queries.GetAllMembershipByPriceQuery;
import com.acme.backend.fithubpro.subscription.domain.model.queries.GetAllMembershipByTypeAndBenefitsQuery;
import com.acme.backend.fithubpro.subscription.domain.model.queries.GetAllMembershipByTypeQuery;
import com.acme.backend.fithubpro.subscription.domain.services.MembershipQueryService;
import com.acme.backend.fithubpro.subscription.infraestructure.persistance.jpa.MembershipRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembershipQueryServiceImpl implements MembershipQueryService {

    private final MembershipRepository membershipRepository;

    public MembershipQueryServiceImpl(MembershipRepository membershipRepository) {
        this.membershipRepository = membershipRepository;
    }

    @Override
    public List<Membership> handle(GetAllMembershipByBenefitsQuery query){
        return membershipRepository.findAllByBenefits(query.benefits());
    }

    @Override
    public List<Membership> handle(GetAllMembershipByPriceQuery query){
        return membershipRepository.findAllByPrice(query.price());
    }

    @Override
    public List<Membership> handle(GetAllMembershipByTypeQuery query){
        return membershipRepository.findAllByType(query.type());
    }

    @Override
    public Optional<Membership> handle(GetAllMembershipByTypeAndBenefitsQuery query){
        return membershipRepository.findAllByTypeAndBenefits(query.type(), query.benefits());
    }





}
