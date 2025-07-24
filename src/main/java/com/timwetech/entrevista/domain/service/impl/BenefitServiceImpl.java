package com.timwetech.entrevista.domain.service.impl;


import com.timwetech.entrevista.domain.entity.Benefit;
import com.timwetech.entrevista.domain.repository.BenefitRepository;
import com.timwetech.entrevista.domain.service.BenefitService;
import com.timwetech.entrevista.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BenefitServiceImpl implements BenefitService {

    private final BenefitRepository benefitRepository;

    @Transactional
    @Override
    public Benefit create(Benefit benefit) {
        return benefitRepository.save(benefit);
    }

    @Override
    public Benefit findById(Long id) {
        return benefitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Benefício não encontrado"));
    }

    @Override
    public List<Benefit> findAll() {
        return benefitRepository.findAll();
    }

    @Transactional
    @Override
    public Benefit update(Long id, Benefit benefit) {
        Benefit existingBenefit = findById(id);
        existingBenefit.setName(benefit.getName());
        existingBenefit.setDescription(benefit.getDescription());
        existingBenefit.setActive(benefit.isActive());
        return benefitRepository.save(existingBenefit);
    }

    @Transactional
    @Override
    public Benefit setActive(Long id, Benefit benefit, boolean active) {
        Benefit existingBenefit = findById(id);
        existingBenefit.setActive(active);
        return benefitRepository.save(existingBenefit);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Benefit benefit = findById(id);
        benefitRepository.delete(benefit);
    }
}

