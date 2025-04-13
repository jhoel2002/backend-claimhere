package com.application.claimhereweb.model.entity;

import jakarta.persistence.Basic;
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
@Table(name = "ch_clientes")
public class customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cliente")
    private Long id_cliente;

    @Basic(optional = false)
    @Column(name = "doc_identidad")
    private String doc_identidad;

    @Basic(optional = false)
    @Column(name = "tipo_doc_identidad")
    private String tipo_doc_identidad;

    @JoinColumn(name = "fk_usuario", referencedColumnName = "id_usuario")
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private user user;
}
