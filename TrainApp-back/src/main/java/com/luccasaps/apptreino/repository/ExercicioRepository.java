package com.luccasaps.apptreino.repository;

import com.luccasaps.apptreino.model.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExercicioRepository extends JpaRepository<Exercicio, UUID> {
}
