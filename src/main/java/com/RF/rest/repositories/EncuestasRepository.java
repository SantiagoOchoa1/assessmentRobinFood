package com.RF.rest.repositories;

import com.RF.rest.entities.Encuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncuestasRepository extends JpaRepository<Encuesta, Long> {
}