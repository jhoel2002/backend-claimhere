package com.application.claimhereweb.model.entity;

import com.application.claimhereweb.model.entity.enumEntity.DocumentCustomertype;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "document_customer_type", nullable = false)
    private DocumentCustomertype document_customer_type;

    @Column(name = "document_number", nullable = false)
    private String document_number;

    @JoinColumn(name = "id_user", referencedColumnName = "id", nullable = false)
    @OneToOne(fetch = FetchType.LAZY)
    private User user;
}