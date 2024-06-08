package com.acme.backend.fithubpro.subscription.infraestructure.persistance.jpa;

import com.acme.backend.fithubpro.subscription.domain.model.aggregates.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, Long> {
    List<Membership> findAllByBenefits(String benefits);
    List<Membership> findAllByPrice(double price);
    List<Membership> findAllByType(String type);
    boolean existsByType(String type);
    Optional<Membership>findAllByTypeAndBenefits(String type, String benefits);

}
