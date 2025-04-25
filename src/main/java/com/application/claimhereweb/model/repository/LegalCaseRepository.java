package com.application.claimhereweb.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.claimhereweb.model.entity.LegalCase;

public interface LegalCaseRepository extends JpaRepository<LegalCase, Long> {
    
}
