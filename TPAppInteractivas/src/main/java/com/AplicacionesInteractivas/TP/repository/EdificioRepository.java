package com.AplicacionesInteractivas.TP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AplicacionesInteractivas.TP.entity.Edificio;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Long>{

}
