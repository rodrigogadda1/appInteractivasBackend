package com.AplicacionesInteractivas.TP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AplicacionesInteractivas.TP.entity.Inspector;

@Repository
public interface InspectorRepository extends JpaRepository<Inspector, Long> {

}
