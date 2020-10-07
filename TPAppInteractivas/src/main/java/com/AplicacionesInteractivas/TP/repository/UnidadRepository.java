package com.AplicacionesInteractivas.TP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AplicacionesInteractivas.TP.entity.Unidad;

@Repository
public interface UnidadRepository extends JpaRepository<Unidad, Long> {

}
