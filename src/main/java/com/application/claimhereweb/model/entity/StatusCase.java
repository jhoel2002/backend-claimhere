package com.application.claimhereweb.model.entity;

import java.security.Timestamp;

import jakarta.persistence.Basic;
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
@Table(name = "status_case")
public class StatusCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Basic(optional = false)
    @Column(name = "old_status")
    private String old_status;

    @Basic(optional = false)
    @Column(name = "new_status")
    private String new_status; 

    @Basic(optional = false)
    @Column(name = "change_date")
    private Timestamp change_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_case", referencedColumnName = "id")
    private Case caseEntity;
}
