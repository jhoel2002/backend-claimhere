package com.application.claimhereweb.model.entity;

import java.sql.Date;

import com.application.claimhereweb.model.entity.enumEntity.CaseRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "case_team_user")
public class CaseTeamUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "case_id", referencedColumnName = "id", nullable = false)
    private LegalCase legalCase;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    private CaseRole caseRole;

    @JoinColumn(name = "asignation_date", nullable = false)
    private Date asignation_date;
}
