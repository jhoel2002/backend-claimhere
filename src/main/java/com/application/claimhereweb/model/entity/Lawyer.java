package com.application.claimhereweb.model.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "lawyers")
public class Lawyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    // Un abogado solo puede pertenecer a una area y dentro de una area puede haber
    // muchos abogados
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_area", referencedColumnName = "id")
    private Area area;

    @JoinColumn(name = "fk_user", referencedColumnName = "id")
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private User user;
}
