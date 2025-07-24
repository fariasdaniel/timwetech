package com.timwetech.entrevista.controller;

import com.timwetech.entrevista.domain.entity.Benefit;
import com.timwetech.entrevista.domain.service.BenefitService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/benefits")
@RequiredArgsConstructor
@Tag(name = "Benefícios", description = "API para gerenciamento de benefícios")
public class BenefitController {

    @Autowired
    private final BenefitService benefitService;

    @PostMapping
    @Operation(summary = "Criar um novo benefício")
    public ResponseEntity<Benefit> create(@Valid @RequestBody Benefit benefit) {
        return new ResponseEntity<>(benefitService.create(benefit), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar um benefício por ID")
    public ResponseEntity<Benefit> findById(@PathVariable Long id) {
        return ResponseEntity.ok(benefitService.findById(id));
    }

    @GetMapping
    @Operation(summary = "Listar todos os benefícios")
    public ResponseEntity<List<Benefit>> findAll() {
        return ResponseEntity.ok(benefitService.findAll());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um benefício")
    public ResponseEntity<Benefit> update(@PathVariable Long id, @Valid @RequestBody Benefit benefit) {
        return ResponseEntity.ok(benefitService.update(id, benefit));
    }

    @PutMapping("/{id}/deactivate")
    @Operation(summary = "Desativar um benefício")
    public ResponseEntity<Benefit> deactivate(@PathVariable Long id, @Valid @RequestBody Benefit benefit) {
        return ResponseEntity.ok(benefitService.setActive(id, benefit, false));
    }

    @PutMapping("/{id}/activate")
    @Operation(summary = "Ativar um benefício")
    public ResponseEntity<Benefit> active(@PathVariable Long id, @Valid @RequestBody Benefit benefit) {
        return ResponseEntity.ok(benefitService.setActive(id, benefit, true ));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir um benefício")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        benefitService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
