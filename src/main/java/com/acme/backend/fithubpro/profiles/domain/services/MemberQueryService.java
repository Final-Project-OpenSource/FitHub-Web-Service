package com.acme.backend.fithubpro.profiles.domain.services;

import com.acme.backend.fithubpro.profiles.domain.model.aggregates.Member;
import com.acme.backend.fithubpro.profiles.domain.model.queries.GetAllMembersQuery;
import com.acme.backend.fithubpro.profiles.domain.model.queries.GetMemberByIdQuery;

import java.util.List;
import java.util.Optional;

public interface MemberQueryService {
    Optional<Member> handle(GetMemberByIdQuery query);
    List<Member> handle(GetAllMembersQuery query);
}
