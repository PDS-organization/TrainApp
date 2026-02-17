package com.luccasaps.apptreino.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.UUID;

@Entity
@Table(name = "exercicios", schema = "public")
@Data
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @OneToOne
    private Serie serie;

    @Column(name = "grupo_muscular", nullable = false)
    private String grupoMuscular;

    @Column(nullable = false)
    private String descricao;

    @Column(name = "video_url",nullable = false)
    private String videoUrl;
}
