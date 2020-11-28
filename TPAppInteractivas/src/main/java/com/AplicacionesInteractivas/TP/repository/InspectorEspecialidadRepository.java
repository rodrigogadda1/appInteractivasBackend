package com.AplicacionesInteractivas.TP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AplicacionesInteractivas.TP.entity.InspectorEspecialidad;


@Repository
public interface InspectorEspecialidadRepository extends JpaRepository<InspectorEspecialidad, Long>{

}