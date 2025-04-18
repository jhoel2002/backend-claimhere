package com.application.claimhereweb.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.claimhereweb.model.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
