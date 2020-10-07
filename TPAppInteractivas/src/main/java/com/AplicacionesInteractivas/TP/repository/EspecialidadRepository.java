package com.AplicacionesInteractivas.TP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.AplicacionesInteractivas.TP.entity.Especialidad;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, Long>{

}
