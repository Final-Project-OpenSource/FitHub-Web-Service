package com.acme.backend.fithubpro.progress.infrastructure.persistence.jpa;

import com.acme.backend.fithubpro.progress.domain.model.aggregate.Progress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProgressRepository extends JpaRepository<Progress, Long> {
    List<Progress> findAllByClientId(Integer clientId);
    Optional<Progress> findByIdAndClientId(Long id, Integer clientId);
    List<Progress> findAllByClientIdAndCoachId(Integer clientId, Integer coachId);
}
