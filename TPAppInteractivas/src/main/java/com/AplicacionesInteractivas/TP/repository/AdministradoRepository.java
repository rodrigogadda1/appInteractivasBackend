package com.AplicacionesInteractivas.TP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AplicacionesInteractivas.TP.entity.Administrado;

@Repository
public interface AdministradoRepository extends JpaRepository<Administrado, Long>{

}
