package com.AplicacionesInteractivas.TP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.AplicacionesInteractivas.TP.entity.Reclamo;

@Repository
public interface ReclamoRepository extends JpaRepository<Reclamo, Long> {

}
