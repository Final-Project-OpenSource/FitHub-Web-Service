package com.acme.backend.fithubpro.profiles.infrastructure.persistence.jpa.repositories;

import com.acme.backend.fithubpro.profiles.domain.model.aggregates.Profile;
import com.acme.backend.fithubpro.profiles.domain.model.valueobjects.EmailAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository for {@link Profile} entities.
 */
@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByEmail(EmailAddress emailAddress);
}
