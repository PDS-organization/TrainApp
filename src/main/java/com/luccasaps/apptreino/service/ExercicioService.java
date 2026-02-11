package com.luccasaps.apptreino.service;

import com.luccasaps.apptreino.model.Exercicio;
import com.luccasaps.apptreino.repository.ExercicioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ExercicioService {

    private final ExercicioRepository repository;

    public List<Exercicio> getAll() {
        return repository.findAll();
    }

    public Exercicio getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exercício não encontrado"));
    }

    public Exercicio save(Exercicio exercicio) {
        return repository.save(exercicio);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

}
