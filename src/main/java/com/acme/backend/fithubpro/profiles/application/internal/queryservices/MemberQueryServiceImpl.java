package com.acme.backend.fithubpro.profiles.application.internal.queryservices;

import com.acme.backend.fithubpro.profiles.domain.model.aggregates.Member;
import com.acme.backend.fithubpro.profiles.domain.model.queries.GetAllMembersQuery;
import com.acme.backend.fithubpro.profiles.domain.model.queries.GetMemberByIdQuery;
import com.acme.backend.fithubpro.profiles.domain.services.MemberQueryService;
import com.acme.backend.fithubpro.profiles.infrastructure.persistence.jpa.repositories.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberQueryServiceImpl implements MemberQueryService {
    private final MemberRepository memberRepository;

    public MemberQueryServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Optional<Member> handle(GetMemberByIdQuery query) {
        return memberRepository.findById(query.memberId());
    }

    @Override
    public List<Member> handle(GetAllMembersQuery query) {
        return memberRepository.findAll();
    }
}