package com.luccasaps.apptreino.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_treino_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private ItemTreino itemTreino;

    @Column(nullable = false)
    private Integer carga;

    @Column(nullable = false)
    private Integer repeticoes;
}
