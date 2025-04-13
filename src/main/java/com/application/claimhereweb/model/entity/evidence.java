package com.application.claimhereweb.model.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ch_evidencias")
public class evidence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_evidencia")
    private Long id_evidencia;

    @Basic(optional = false)
    @Column(name = "ext_file")
    private String ext_file;

    @Basic(optional = false)
    @Lob
    @Column(name = "file_evidencia")
    private byte[] file_evidencia;

    @Basic(optional = false)
    @Column(name = "nombre_file")
    private String nombre_file;

    @JoinColumn(name = "fk_reclamo", referencedColumnName = "id_reclamo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private claim claim;
}
