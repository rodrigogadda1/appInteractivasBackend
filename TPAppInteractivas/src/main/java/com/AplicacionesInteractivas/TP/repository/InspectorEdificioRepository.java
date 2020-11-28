package com.AplicacionesInteractivas.TP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.AplicacionesInteractivas.TP.entity.InspectorEdificio;

@Repository
public interface InspectorEdificioRepository extends JpaRepository<InspectorEdificio, Long>{

}
