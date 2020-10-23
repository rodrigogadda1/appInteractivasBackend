package com.AplicacionesInteractivas.TP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AplicacionesInteractivas.TP.entity.AdministradoUnidad;

@Repository
public interface AdministradoUnidadRepository extends JpaRepository<AdministradoUnidad, Long>{

}
