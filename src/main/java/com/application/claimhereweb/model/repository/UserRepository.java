package com.application.claimhereweb.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.claimhereweb.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // @Query(value = "SELECT " +
    //         "cu.id_usuario, " +
    //         "cu.nombres, " +
    //         "cu.apellidos, " +
    //         "cu.correo, " +
    //         "cu.password, " +
    //         "cu.tipo_usuario " +
    //         "FROM ch_usuarios cu " +
    //         "WHERE cu.tipo_usuario IN ('Admin', 'Empleado');", nativeQuery = true)
    // public List<User> findUserByAdminEmpleado();

    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
}