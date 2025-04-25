package com.application.claimhereweb.model.entity;

import java.security.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "case_change_status")
public class CaseChangeStatus {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "old_status", nullable = false)
    private String old_status;

    @Column(name = "new_status", nullable = false)
    private String new_status; 

    @Column(name = "change_date")
    private Timestamp change_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_legal_Case", referencedColumnName = "id", nullable = false)
    private LegalCase legal_case;
}
