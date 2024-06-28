package com.acme.backend.fithubpro.profiles.infrastructure.persistence.jpa.repositories;

import com.acme.backend.fithubpro.profiles.domain.model.aggregates.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoachRepository extends JpaRepository<Coach, Long>{
    Optional<Coach> findByProfileId(Long profileId);
}
