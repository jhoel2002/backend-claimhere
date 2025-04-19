package com.application.claimhereweb.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.claimhereweb.model.entity.StatusCase;

public interface StatusCaseRepository extends JpaRepository<StatusCase, Long> {
    
}
