package com.AplicacionesInteractivas.TP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.AplicacionesInteractivas.TP.entity.Notificacion;

@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {

}
