package com.application.claimhereweb.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.claimhereweb.model.entity.Lawyer;

public interface LawyerRepository extends JpaRepository<Lawyer, Long> {

}
