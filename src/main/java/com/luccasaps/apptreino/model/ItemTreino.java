package com.luccasaps.apptreino.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.UUID;

@Entity
@Data
@Table(name = "Item_Treino", schema = "public")
@EntityListeners(AuditingEntityListener.class)
public class ItemTreino {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "ficha_id", nullable = false)
    private FichaTreino fichaId;

    @ManyToOne
    @JoinColumn(name = "exercicio_id", nullable = false)
    private Exercicio exerciciosId;

    @Column(nullable = false)
    private Integer series;

    @Column(nullable = false)
    private Integer repeticoes;

    @Column(nullable = false)
    private Integer carga;

    @Column(nullable = false)
    private String observacoes;
}
