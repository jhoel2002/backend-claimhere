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
@Table(name = "ch_usuarios")
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Long id_usuario;

    @Basic(optional = false)
    @Column(name = "nombres")
    private String nombre_usuario;

    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellido_usuario;

    @Basic(optional = false)
    @Column(name = "correo")
    private String correo_usuario;

    @Basic(optional = false)
    @Column(name = "password")
    private String password_usuario;

    @Basic(optional = false)
    @Column(name = "tipo_usuario")
    private String tipo_usuario;
}
