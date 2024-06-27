package com.acme.backend.fithubpro.rutines.infrastructure.persistance.jpa;

import com.acme.backend.fithubpro.rutines.domain.model.aggregate.Rutines;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RutinesRepository extends JpaRepository<Rutines, Long> {
    List<Rutines> findAllByName(String name);
    Optional<Rutines> findById(Long id);


}
