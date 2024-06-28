package com.acme.backend.fithubpro.rutines.infrastructure.persistance.jpa;

import com.acme.backend.fithubpro.rutines.domain.model.aggregate.Rutines;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RutinesRepository extends JpaRepository<Rutines, Long> {
    List<Rutines> findAllByExercise(String exercise);
    List<Rutines> findAllByInstruction(String instruction);
    List<Rutines> findAllByCoachId(Long coachId);
    List<Rutines> findAllByMemberId(Long memberId);
}
