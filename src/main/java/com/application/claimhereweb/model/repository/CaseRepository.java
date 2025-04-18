package com.application.claimhereweb.model.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.claimhereweb.model.entity.Case;

public interface CaseRepository extends JpaRepository<Case, Long> {
}
