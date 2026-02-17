package com.luccasaps.apptreino.controller;

import com.luccasaps.apptreino.model.Exercicio;
import com.luccasaps.apptreino.service.ExercicioService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/exercicios")
public class ExercicioController {

    private final ExercicioService exercicioService;

    public ResponseEntity<List<Exercicio>> getAll(){
        return ResponseEntity.ok(exercicioService.getAll());
    }
}
