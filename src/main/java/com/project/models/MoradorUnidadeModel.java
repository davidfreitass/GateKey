package com.project.models;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Morador_Unidade", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"morador_id", "unidade_id"}, name = "UK_Morador_Unidade")
})
public class MoradorUnidadeModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(
            name = "morador_idMorador",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_MoradorUnidade_Morador_ID")
    )
    private MoradorModel morador;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(
            name = "unidade_idUnidade",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_MoradorUnidade_Unidade_ID")
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