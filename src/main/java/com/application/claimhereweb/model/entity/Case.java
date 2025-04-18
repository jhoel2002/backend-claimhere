package com.application.claimhereweb.model.entity;

import java.sql.Date;

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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
@Entity
@Table(name = "legal_cases")
public class Case {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Basic(optional = false)
    @Column(name = "title")
    private String title;

    @Basic(optional = false)
    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_area", referencedColumnName = "id")
    private Area area;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_customer", referencedColumnName = "id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_lawyer", referencedColumnName = "id")
    private Lawyer lawyer;

    @Basic(optional = false)
    @Column(name = "event_date")
    @Temporal(TemporalType.DATE)
    private Date event_date;

    @Basic(optional = false)
    @Column(name = "location")
    private String location;

    @Basic(optional = false)
    @Column(name = "priority")
    private String priority;

    @Basic(optional = false)
    @Column(name = "status")
    private String status;
}