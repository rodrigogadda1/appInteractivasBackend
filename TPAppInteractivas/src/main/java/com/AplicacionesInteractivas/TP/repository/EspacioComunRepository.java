package com.AplicacionesInteractivas.TP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AplicacionesInteractivas.TP.entity.EspacioComun;

@Repository
public interface EspacioComunRepository extends JpaRepository<EspacioComun, Long>{

}
