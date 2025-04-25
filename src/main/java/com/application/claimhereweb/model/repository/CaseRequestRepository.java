package com.application.claimhereweb.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.claimhereweb.model.entity.CaseRequest;

public interface CaseRequestRepository extends JpaRepository<CaseRequest, Long> {

}
