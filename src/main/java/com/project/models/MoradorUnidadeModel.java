package com.project.models;

import jakarta.persistence.*;

@Entity
@Table(name = "morador_unidade", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"morador_id_morador", "unidade_id_unidade"}, name = "uk_morador_unidade")
})
public class MoradorUnidadeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public MoradorUnidadeModel(Long id) {
        this.id = id;
    }

    @ManyToOne()
    @JoinColumn(
            name = "morador_id_morador",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_morador_unidade_morador_id")
    )
    private MoradorModel morador;

    @ManyToOne()
    @JoinColumn(
            name = "unidade_id_unidade",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_morador_unidade_unidade_id")
    )
    private UnidadeModel unidade;

    public MoradorUnidadeModel() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MoradorModel getMorador() {
        return morador;
    }

    public void setMorador(MoradorModel morador) {
        this.morador = morador;
    }

    public UnidadeModel getUnidade() {
        return unidade;
    }

    public void setUnidade(UnidadeModel unidade) {
        this.unidade = unidade;
    }
}