package com.timwetech.entrevista.domain.service;

import com.timwetech.entrevista.domain.entity.Benefit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BenefitService {
    @Transactional
    Benefit create(Benefit benefit);

    Benefit findById(Long id);

    List<Benefit> findAll();

    @Transactional
    Benefit update(Long id, Benefit benefit);

    @Transactional
    Benefit setActive(Long id, Benefit benefit, boolean active);

    @Transactional
    void delete(Long id);
}
