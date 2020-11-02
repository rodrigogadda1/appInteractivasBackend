package com.AplicacionesInteractivas.TP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.AplicacionesInteractivas.TP.entity.Foto;

@Repository
public interface FotoRepository extends JpaRepository<Foto, Long>{

}
