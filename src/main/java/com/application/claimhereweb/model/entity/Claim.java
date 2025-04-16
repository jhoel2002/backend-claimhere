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
import lombok.Data;

@Data
@Entity
@Table(name = "ch_reclamos")
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_reclamo")
    private Long id_reclamo;

    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo_reclamo;

    @Basic(optional = false)
    @Column(name = "fecha")
    private Date fecha_reclamo;

    @Basic(optional = false)
    @Column(name = "puntuacion")
    private Long puntuacion;

    @Basic(optional = false)
    @Column(name = "reclamo")
    private String descripcion_reclamo;

    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo_reclamo;

    @Basic(optional = false)
    @Column(name = "estado_reclamo")
    private String estado_reclamo;

    @JoinColumn(name = "fk_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Customer customer;

    @JoinColumn(name = "fk_empresa", referencedColumnName = "id_empresa")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Company company;
}
