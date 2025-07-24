package com.timwetech.entrevista.domain.repository;

import com.timwetech.entrevista.domain.entity.Benefit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenefitRepository extends JpaRepository<Benefit, Long> {
}

