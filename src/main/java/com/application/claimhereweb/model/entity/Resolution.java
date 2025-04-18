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
@Table(name = "resolutions")
public class Resolution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Basic(optional = false)
    @Column(name = "rute_resolution")
    private String rute_resolution;

    @Basic(optional = false)
    @Column(name = "register_date")
    private Timestamp register_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_case", referencedColumnName = "id")
    private Case value_case;
}
