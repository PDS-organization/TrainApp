package com.luccasaps.apptreino.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.UUID;

@Entity
@Table(name = "series", schema = "public")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    private Exercicio exercicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_treino_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private FichaTreino fichaTreino;

    @Column(nullable = false)
    private Double carga;

    @Column(nullable = false)
    private Integer repeticoes;

    @CreatedBy()
    private UUID personalId;
}
