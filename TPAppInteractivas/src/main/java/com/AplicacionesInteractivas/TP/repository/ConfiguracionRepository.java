package com.AplicacionesInteractivas.TP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AplicacionesInteractivas.TP.entity.Configuracion;



@Repository
public interface ConfiguracionRepository extends JpaRepository<Configuracion, Long>{

}
