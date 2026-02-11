package com.luccasaps.apptreino.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "item_treino", schema = "public")
@EntityListeners(AuditingEntityListener.class)
public class ItemTreino {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ficha_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private FichaTreino fichaTreino;

    @ManyToOne(fetch = FetchType.EAGER) // Geralmente queremos ver o nome do exercício
    @JoinColumn(name = "exercicio_id", nullable = false)
    private Exercicio exercicio;

    @OneToMany(mappedBy = "itemTreino", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Serie> series;

    @Column(nullable = true)
    private String observacoes;

    public void setFichaId(FichaTreino fichaTreino) {
        this.fichaTreino = fichaTreino;
        fichaTreino.getItens().add(this);
    }
}
