package com.acme.backend.fithubpro.profiles.infrastructure.persistence.jpa.repositories;

import com.acme.backend.fithubpro.profiles.domain.model.aggregates.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByProfileId(Long profileId);
    Optional<Member> findById(Long memberId);
}
