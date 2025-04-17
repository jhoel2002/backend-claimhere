package com.application.claimhereweb.model.entity;

import java.util.HashSet;
import java.util.Set;

import com.application.claimhereweb.validation.ExistsByEmail;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @Column(name = "last_name")
    private String last_name;

    @ExistsByEmail
    @NotBlank
    @Basic(optional = false)
    @Column(name = "email", unique = true)
    private String email;

    @NotBlank
    @Basic(optional = false)
    @Column(name = "password")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;

    @Basic(optional = false)
    @Column(name = "enabled")
    private boolean enabled;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Role.class)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "id_user"),inverseJoinColumns = @JoinColumn(name = "id_role"))
    @Column(name = "roles")
    private Set<Role> roles = new HashSet<>();

    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private boolean admin;

    @PrePersist
    public void prePersist() {
        enabled = true;
    }
}
