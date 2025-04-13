package com.application.claimhereweb.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.application.claimhereweb.model.entity.user;

public interface userRepository extends JpaRepository<user, Long> {
    @Query(value = "SELECT " +
            "cu.id_usuario, " +
            "cu.nombres, " +
            "cu.apellidos, " +
            "cu.correo, " +
            "cu.password, " + // ← ¡coma agregada aquí!
            "cu.tipo_usuario " +
            "FROM ch_usuarios cu " +
            "WHERE cu.tipo_usuario IN ('Admin', 'Empleado');", nativeQuery = true)
    public List<user> findUserByAdminEmpleado();
}