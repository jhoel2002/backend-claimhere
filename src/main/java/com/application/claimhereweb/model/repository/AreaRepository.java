package com.application.claimhereweb.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.application.claimhereweb.model.entity.Area;

public interface AreaRepository extends JpaRepository<Area, Long> {

    @Query("SELECT a.name FROM Area a WHERE a.id = :id")
    String findNameById(@Param("id") Long id);
}
