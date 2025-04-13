package com.application.claimhereweb.model.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ch_empresas")
public class company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_empresa")
    private Long id_empresa;

    @Basic(optional = false)
    @Column(name = "email")
    private String email_empresa;

    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion_empresa;

    @Basic(optional = false)
    @Column(name = "image_logo")
    private String image_logo;

    @Basic(optional = false)
    @Column(name = "nombre_comercial")
    private String nombre_comercial;

    @Basic(optional = false)
    @Column(name = "razon_social")
    private String razon_social;

    @Basic(optional = false)
    @Column(name = "ruc")
    private String ruc_empresa;

    @Basic(optional = false)
    @Column(name = "pagina_web")
    private String pagina_web;
}
