package com.application.claimhereweb.model.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

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
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "last_name", nullable = false)
    private String last_name;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "creation")
    private Date creation;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Role.class)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "id_users"), inverseJoinColumns = @JoinColumn(name = "id_role"))
    @Column(name = "roles")
    private Set<Role> roles = new HashSet<>();

    @Column(name = "enabled")
    private boolean enabled;

    @PrePersist
    public void prePersist() {
        enabled = true;
    }

    public String getFirstRoleName() {
        return roles.stream().findFirst().map(Role::getName).orElse("");
        //return roles.stream().findFirst().map(Role::getName);
    }
}
